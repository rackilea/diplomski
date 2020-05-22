public boolean equals(Object c) {
    if(c !instanceof C) {
        return false;
    }

    C that = (C)c;
    return this.str1.equals(that.getStr1()) && this.str2.equals(that.getStr2());
}