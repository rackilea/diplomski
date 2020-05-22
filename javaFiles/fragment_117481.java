public static <T extends LocationAware> T changeLocationName(String local, T object) {
    for (International international : object.getInternationals()) {
        if(local.equals(international.getLanguage())) {
            object.setName(international.getTranslation());
        }
    }
    return object;
}