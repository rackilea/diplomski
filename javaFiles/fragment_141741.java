StringBuilder sb = new StringBuilder("");

    for (Entry<String, JsonElement> entry : json.entrySet()) {

        if (entry.getValue().isJsonObject()) {
            sb.append(getJsonTokenize(entry.getValue().getAsJsonObject()));
        } else {
            sb.append(entry.getValue().getAsString());
        }

    }

    return sb.toString();