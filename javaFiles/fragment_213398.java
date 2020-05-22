List<String> secondArrayList = new ArrayList<>();
for (String eachString : list) {
    if (eachString.length() < 100) { // <-- is it 100 or fewer chars?
        secondArrayList.add(eachString);
    } else { // <-- otherwise, take the first 100 chars.
        secondArrayList.add(eachString.substring(0, 100));
    }
}