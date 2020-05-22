List<String[]> arrayList = new ArrayList<>();

    while ((myLine = bufRead.readLine()) != null) {
        String[] vals = myLine.split("   ");
        arrayList.add(vals);
    }