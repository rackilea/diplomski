List<List<String>> dataList = new ArrayList<>();
    for (int i=0; i<data.length; i++) {
        List<String> temp = new ArrayList<>();
        Collections.addAll(temp, data[i]);
        temp.removeAll(Collections.singleton(null));
        if (!temp.isEmpty()) {
            dataList.add(temp);
        }
    }