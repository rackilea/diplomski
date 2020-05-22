public Vector<Vector> getDataVector() {
        Vector rowOne = new Vector<String>();
        rowOne.add("Row1-Column1");
        Vector rowOneCategories = new Vector();
        rowOneCategories.add("Row1-Column2-Line1");
        rowOneCategories.add("Row1-Column2-Line2");
        rowOneCategories.add("Row1-Column2-Line3");
        rowOne.add(rowOneCategories);

        Vector rowTwo = new Vector<String>();
        rowTwo.add("Row2-Column1");
        Vector rowTwoCategories = new Vector();
        rowTwoCategories.add("Row2-Column2-Line1");
        rowTwoCategories.add("Row2-Column2-Line2");
        rowTwoCategories.add("Row2-Column2-Line3");
        rowTwo.add(rowTwoCategories);

        Vector<Vector> rowData = new Vector<Vector>();
        rowData.add(rowOne);
        rowData.add(rowTwo);

        return rowData;
    }