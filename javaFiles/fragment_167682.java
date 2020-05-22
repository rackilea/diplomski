List<String> compareObjects(PartInfo filePart, PartInfo dbPart) {
    List<String> different = new LinkedList<String>();

    if (!filePart.getNumber().equals(dbPart.getNumber())) {
        different.add("number");
    }
    //repeat for all your fields
    return different;
}