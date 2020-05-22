list.parallelStream()
    .forEach(map -> {
        setFilePathAndOffsetParams(map);
        for (Map.Entry<String, String> entry : anotherMap.entrySet()) {
            updateKeyOnMap(map, entry.getKey(), entry.getValue());
        }
    });