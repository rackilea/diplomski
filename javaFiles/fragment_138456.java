public boolean validateData(Bagform[] bagdata) {
    for (Bagform form : bagdata) {
        if (form.getCallType() == null) {
            return false;
        }
    }
    return true;
}