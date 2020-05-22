List<List<Object>> myRowValues = new ArrayList<>();
    for (int j = 0; j < myRowCount; j++) {
        myRowValues.add(j, new ArrayList<>());
        for (int i = 0; i < myColumnCount; i++) {
            myRowValues.get(j).add(aDestinationTable.getValueAt(j, i));
        }
    }

    System.out.println(myRowValues);