private CustomObject getObjectFromString(String objectDataString) {
    Objects.requireNonNull(objectDataString, "objectDataString should not be null");
    String[] customObjectComponents = objectDataString.split(":");
    if (customObjectComponents.length != 2) {
        throw new IllegalArgumentException("Malformed string: " + objectDataString);
    }

    EnumObjectType type = EnumObjectType.valueOf(customObjectComponents[0]);
    try {
        int value = Integer.parseInt(customObjectComponents[1]);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException(customObjectComponents[1] + " is not an integer);
    }

    CustomObject singleObject = new CustomObject(type, value);
    if (isValidCustomObject(singleObject)) {
        return singleObject;
    } else {
        throw new IllegalArgumentException("Unknown custom object type/value: " + type + ":" + value);
    }
}