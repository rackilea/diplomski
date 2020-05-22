public boolean validateData(Bagform[] bagdata) {
    boolean flag = true;
    int length = bagdata.length;

    if (length == 2) {
        for (int i = 0; i < bagdata.length; i++) {
            if (bagdata[i].getCallType() == null) {
                flag = false;
            }
        }
    }
    return flag;
}