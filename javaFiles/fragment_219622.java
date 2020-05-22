Iterator<String> keys = exclusionObj.keys();
    while(keys.hasNext()) {
        if (!exclusionObj.isNull(keys.next())) {
            sample.setName(exclusionObj.getString(keys.next()));
        }
    }