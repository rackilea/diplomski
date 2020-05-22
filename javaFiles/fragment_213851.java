public void getImagefromGoogleUrl(Consumer<ArrayList<String>> consumer) {
    ...
    webengine.documentProperty().addListener((obs, oldDoc, newDoc) -> {
        ... fill list
        // no pass it to the consumer
        consumer.accept(resultList); 
    });
}