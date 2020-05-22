@POST
@Path("/getBsgHandles")
    @Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public BsgHandleResponse getBsgHandlesJson(MyRequestObject obj) {

    HttpServletRequest request = getRequestObject();

    LOGGER.debug("getBsgHandlesJson() called for rateCodes="
            + obj.getRateCodes().toString() + " from ip" + request.getRemoteAddr());

    return processGetBsgHandleByRateCode(obj.getAppkey(), obj.getRateCodes(), obj.getCorp(), 
        obj.getHeadendDesignator(), obj.getEqpProtocolAiu(), obj.getEqpTypAiu(), 
                    obj.getForceUpdate(), request);
}