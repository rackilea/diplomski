sortHandler.setComparator(column1, new Comparator<myDTO>() {
    public int compare(myDTO dto1, myDTO dto2) {
        // This is an example, how you compare them depends on the context
        return dto1.getSomeData1().compareTo(dto2.getSomeData1());
    }
});

myTable.getColumnSortList().push(column1);