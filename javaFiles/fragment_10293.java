@Override
protected SerializationPolicy doGetSerializationPolicy(
        HttpServletRequest request, String moduleBaseURL, String strongName) {
    SerializationPolicy sp = super.doGetSerializationPolicy(request,
                                   moduleBaseURL, strongName);
    if(sp == null) { //no policy found, probably wrong client version
        throw new InvalidPolicyException();
    }
    return sp;
}