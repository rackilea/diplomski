Integer rc = (Integer) msgContext.getProperty(HTTPConstants.MC_HTTP_STATUS_CODE);
if (rc != null) {
    returnCode = rc.intValue();
} else {
    // No return code?? Should have one by now.
}