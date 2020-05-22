private CustomObject getObjectFromString(String objectDataString) {
    if (objectDataString != null) {
        String[] customObjectComponents = objectDataString.split(":");
        CustomObject singleObject = new CustomObject(EnumObjectType.valueOf(customObjectComponents[0]),
                Integer.parseInt(customObjectComponents[1]));
        if (isValidCustomObject(singleObject)) {
            return singleObject;
        } else {
            throw new IllegalArgumentException("Unknown custom object type/value: " + EnumObjectType.valueOf(customObjectComponents[0]) + ":"
                    + Integer.parseInt(customObjectComponents[1]));
        }
    }
}