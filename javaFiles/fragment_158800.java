for (int i = 0; i < xpathvaluesList.size();) {
    if (!xpathvaluesList.get(i).contains("_")) {
        xpathvaluesList.remove(xpathvaluesList.get(i));
        System.out.println(xpathvaluesList);
        i = i + 1;
    }
}