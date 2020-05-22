String[][] pass = new String[][]{{"Name","data1","data2"}};
    List<String[]> tempArr = new ArrayList<String[]>(Arrays.asList(pass));
    for (Iterator<String[]> iterator = tempArr.iterator(); iterator.hasNext();) {
        String id = iterator.next()[0];
        if (id.equals(delete_name)){
            iterator.remove();
        }
    }