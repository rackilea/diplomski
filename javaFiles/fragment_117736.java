public String replace(CharSequence target, CharSequence replacement) {
    String tgtStr = target.toString();
    String replStr = replacement.toString();
    int j = indexOf(tgtStr);
    if (j < 0) {
        return this;
    }
    int tgtLen = tgtStr.length();
    int tgtLen1 = Math.max(tgtLen, 1);
    int thisLen = length();
    int newLenHint = thisLen - tgtLen + replStr.length();
    if (newLenHint < 0) {
        throw new OutOfMemoryError();
    }
    StringBuilder sb = new StringBuilder(newLenHint);
    int i = 0;
    do {
        sb.append(this, i, j).append(replStr);
        i = j + tgtLen;
    } while (j < thisLen && (j = indexOf(tgtStr, j + tgtLen1)) > 0);
    return sb.append(this, i, thisLen).toString()
}