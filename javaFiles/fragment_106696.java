public void applyEQ(String col, String val) throws Exception {
    int ret = 0;
    final EConstants constant = EConstants.valueOf(col.toUpperCase());
    switch(constant) {
        case CEWNAME:
            ret = Sample.addName(eQuery, val);
            break;
        case CEWROLE:
            ret = Sample.addRole(eQuery, val);
            break;
        case CEWKEYWORDS:
            ret = Sample.addKey(eQuery, val);
            break;
        default:
            throw new Exception("Unhandled enum constant: " + constant);
    }
}