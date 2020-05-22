String s = obj.getvalue();
if (StringUtils.isNotEmpty(s)){ // No NPE possible here now
    if (s == null) {
        System.err.println("Ooops!!");  // Cannot happen now.
    }
}