public class SmppSessionHandlerController extends DefaultSmppSessionHandler {
    private static final Logger log = LoggerFactory.getLogger(SmppSessionHandlerController.class);

    private volatile PduHandler pduHandler;
private PduResponseHandler pduResponseHandler;
private PduRequestHandler pduRequestHandler;

public SmppSessionHandlerController() {
    super(log);
}

public PduHandler getPduHandler() {
    return pduHandler;
}

public void setPduHandler(PduHandler pduHandler) {
    this.pduHandler = pduHandler;
}

public PduResponseHandler getPduResponseHandler() {
    return pduResponseHandler;
}

public void setPduResponseHandler(PduResponseHandler pduResponseHandler) {
    this.pduResponseHandler = pduResponseHandler;
}

public PduRequestHandler getPduRequestHandler() {
    return pduRequestHandler;
}

public void setPduRequestHandler(PduRequestHandler pduRequestHandler) {
    this.pduRequestHandler = pduRequestHandler;
}

@Override
public void fireExpectedPduResponseReceived(PduAsyncResponse pduAsyncResponse) {
    log.trace("Handling response PDU: {}", pduAsyncResponse);
    pduAsyncResponse.getResponse().setReferenceObject(pduAsyncResponse.getRequest().getReferenceObject());
    processPduResponse(pduAsyncResponse.getResponse());
}


@Override
public void fireUnexpectedPduResponseReceived(PduResponse pduResponse) {
    log.warn("Handling unexpected response PDU: {}", pduResponse);
    processPduResponse(pduResponse);
}

@Override
public boolean firePduReceived(Pdu pdu) {
    PduHandler currPduHandler = pduHandler;
    if (currPduHandler != null) {
        SmppPdu smppPdu = PduToApiConverter.convertToApiObject(pdu);
        currPduHandler.handlePduReceived(smppPdu);
    }
    // default handling is to accept pdu for processing up chain
    return true;
}

public void firePduRequestExpired(PduRequest pduRequest) {
    super.firePduRequestExpired(pduRequest);
}

private void processPduResponse(PduResponse pduResponse) {
    HandlersContextHelper referenceObj = (HandlersContextHelper) pduResponse.getReferenceObject();
    if (referenceObj != null) {
        referenceObj.getSequenceIdHolder().addReceivedSequenceId(pduResponse.getSequenceNumber());
    }
    PduResponseHandler pduRespHandler = pduResponseHandler;
    if (pduRespHandler != null) {
        SmppPduResponse smppPduResponse = PduToApiConverter.convertToApiResponse(pduResponse);
        if (smppPduResponse != null) {
            pduRespHandler.handlePduResponse(smppPduResponse);
        }
    }
    if (referenceObj != null) {
        referenceObj.getSequenceIdHolder().checkSentAndReceivedClosed();
    }
}

@Override
public PduResponse firePduRequestReceived(PduRequest pduRequest) {
    PduRequestHandler pduReqHandler = pduRequestHandler;
    PduResponse resultPduResponse = pduRequest.createResponse();
    if (pduReqHandler == null) {
        return resultPduResponse;
    }
    PduResponse defaultPduResponse = pduRequest.createResponse();
    SmppPduRequest smppPduRequest = PduToApiConverter.convertToApiRequest(pduRequest);
    SmppPduResponse defaultSmppPduResponse = PduToApiConverter.convertToApiResponse(defaultPduResponse);
    if (smppPduRequest == null || defaultSmppPduResponse == null) {
        return resultPduResponse;
    }
    SmppPduResponse resultSmppPduResponse = pduReqHandler.handlePduRequest(smppPduRequest, defaultSmppPduResponse);
    if (resultSmppPduResponse == null) {
        return null;
    }
    PduResponse convertedPduResponse = ApiToPduConverter.convertToPduResponse(resultSmppPduResponse);
    if (convertedPduResponse == null) {
        return resultPduResponse;
    }
    if (!resultPduResponse.getClass().isAssignableFrom(convertedPduResponse.getClass())) {
        return resultPduResponse;
    }
    return convertedPduResponse;
}
}