class StylesheetUserPreferencesImpl {
    long id;
    String desc;
    Map<AttributeCoordinate, String> attributes;
}

class AttributeCoordinate {
    String nodeID;
    String prefID;
}