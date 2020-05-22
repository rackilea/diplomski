for (Entry<String, Map<String, String>> outerMapEntry : messagesByFactTypeAndCategory.entrySet()) {
        // do something with outerMapEntry
        System.out.println(outerMapEntry.getKey() + " => " + outerMapEntry.getValue());
        for (Entry<String, String> innerMapEntry : outerMapEntry.getValue().entrySet()) {
            // do something with inner map entry
            System.out.println(innerMapEntry.getKey() + " => " + innerMapEntry.getValue());
        }
    }