void addStation(Station station) {
        JsonObject rootObject = getRootElement().getAsJsonObject();
        JsonArray jsonArray = rootObject.getAsJsonArray("stations");
        jsonArray.add(gson.toJsonTree(station));
        writeToFile(rootObject);
        listView.getItems().add(station);
}