Comparator<SheetData> comparator = null;

comparator = new Comparator<SheetData> {

    public int compare(SheetData sd1, SheetData sd2) {

        int rc = 0;

        if (rc == 0) {
            rc = sd1.getString("Field").compareTo(sd2.getString("Field"));
        }

        if (rc == 0) {
            rc = sd1.getString("Field2").compareTo(sd2.getString("Field2"));
        }

        return rc;
    }
};

Collections.sort(sheetData, comparator);