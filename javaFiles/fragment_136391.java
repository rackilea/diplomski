customTypes {
    customType {
        name = "com.google.gson.JsonElement"
        converter = "com.vault.dao.PostgresJSONGsonBinding"
    }
}
forcedTypes {
    forcedType {
        name = "com.google.gson.JsonElement"
        expression = ".*data.*|.*tags.*"
        types = ".*"
    }
}