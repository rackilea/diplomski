ResourceBundle resourceBundle = ResourceBundle.getBundle(...);

    FXMLLoader loader = new FXMLLoader(getClass().getResource(...), resourceBundle);

    Map<String, Object> resourceAccess = new HashMap<>();
    for (String key : resourceBundle.keySet()) {
        resourceAccess.put(key, resourceBundle.getObject(key));
    }
    loader.getNamespace().put("resourceAccess", resourceAccess);

    Parent root = loader.load() ;