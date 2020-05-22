List<Object[]> tempRows = new ArrayList<Object[]>();
    for (int i = 0; i < 100; i++) {
        Object[] row = new Object[] {"This", "Is", "Just", "Some", "Example", "Data", "Here"};
        tempRows.add(row);
    }
    Object[][] tempRes = (Object[][]) tempRows.toArray(new Object[tempRows.size()][]);