while (excellentCsvReader.readRecord()) {
    ...
    String[] tagsOfTheCurrentPictureAsAnArray = tagsOfTheCurrentPicture.split(",");
    for (String x : tagsOfTheCurrentPictureAsAnArray) {
        myTags.add(x);
    }
    ...
}
Utils y = new Utils();
myConnections.addAll(y.getListOfLinks(tagsOfTheCurrentPictureAsAnArray));