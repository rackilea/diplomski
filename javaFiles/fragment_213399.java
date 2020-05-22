} else {
    // Iterate the word, shrinking by 100 characters...
    while (eachString.length() > 100) {
        secondArrayList.add(eachString.substring(0, 100));
        eachString = eachString.substring(100);
    }
    // Check if there is anything left...
    if (!eachString.isEmpty()) {
        secondArrayList.add(eachString);
    }
}