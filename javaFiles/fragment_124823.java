nextMethod();
synchronized(secondList) {
    currentObject = (Object[]) secondList.get(0); // should no longer throw an exception
}

synchronized(secondList) {
    // create Objects
    secondList.add(objects);
}