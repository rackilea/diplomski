private void logInfo() {
    for (ArrayList<String> arrayList : outerArrayList) {
        for (String s: arrayList) {
            Log.d("tag", s);
        }
    }
}