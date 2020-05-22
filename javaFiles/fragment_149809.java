Optional<Integer> findAny = sectionsJson.keySet().stream().filter(key -> {
        Map<String, Object> section = (Map<String, Object>)sectionsJson.get(key);
        if (index == (Integer)section.get("SECTION_FIELD_KEY_INDEX")) {
            section.put("SECTION_FIELD_KEY_SECTION_KEY", key);
            return true;
        }
        return false;

    }).findFirst();
    if (findAny.isPresent()) {
        System.out.println(sectionsJson.get(findAny.get()));
    }