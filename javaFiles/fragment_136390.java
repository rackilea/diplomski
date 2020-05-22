customTypes {
    customType {
        // Lacking a "type" definition, jOOQ uses the "name" as the "type":
        name = "JsonElement"
        converter = "com.vault.dao.PostgresJSONGsonBinding"
    }
}
forcedTypes {
    forcedType {
        name = "JsonElement"
        expression = ".*data.*|.*tags.*"
        types = ".*"
    }
}