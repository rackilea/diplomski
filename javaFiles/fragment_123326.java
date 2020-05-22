public double getDouble(String str) {

    if (str != null) {

        if (str.equalsIgnoreCase("")) {
            return 0;
        } else {
            return Double.parseDouble(str);
        }
    } else {
        return 0;
    }
}