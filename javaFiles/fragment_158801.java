public ArrayList<String> useXpathValues() throws IOException {
    ArrayList<String> xpathvaluesList = getMbunValues();
    Iterator<String> iterator = xpathvaluesList.iterator();

    while(iterator.hasNext()) {
        String next = iterator.next();
        if (! next.contains("_")) {
            iterator.remove();
        }
    }

    for (int i = 0; i < xpathvaluesList.size(); i++) {
        System.out.println(xpathvaluesList.get(i));
    }
    return xpathvaluesList;
}