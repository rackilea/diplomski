// (#1) either:
class PmtRequest {
    // guarantee non-null requestDetails
    List<rRequestDetail> requestDetails = new ArrayList<>(); 


// (#2) or:
when
$paymentHolder: PaymentHolder(errors.size() == 0,
                pmtRequest != null &&
                pmtRequest.getRequestDetails() ... )
then ...