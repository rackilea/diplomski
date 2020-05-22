private void combineArray(List<String> lOut, String sPrefix, String[] sInput, int iLength) {
    if (iLength == sPrefix.length()) {
        //This value should be returned and concatenated:
        System.out.println(sPrefix);
        lOut.add(sPrefix);
    } else {
        for (int i=0; i<sInput.length; i++) {
            combineArray(lOut, sPrefix.concat(sInput[i]), ArrayUtils.removeElement(sInput, sInput[i]), iLength);
        }
    }
}