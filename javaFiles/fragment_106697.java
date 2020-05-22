private int processSample(String val, EConstants constant) throws Exception {
    switch(constant) {
        case CEWNAME:
            return Sample.addName(eQuery, val);
        case CEWROLE:
            return Sample.addRole(eQuery, val);
        case CEWKEYWORDS:
            return Sample.addKey(eQuery, val);
        default:
            throw new Exception("Unhandled enum constant: " + constant);
    }
}