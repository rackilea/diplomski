for (Iterator<String[]> iterator = arrayList.iterator();iterator.hasNext();) {
    String[] stringArray = iterator.next();
    if("R111".equals(stringArray[0])) {
        iterator.remove();
    }
}