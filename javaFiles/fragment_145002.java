List<Map<String, String>> list2 = list.stream().map(e -> {
        Map<String, String> map = new HashMap<>();
        for (Map.Entry x : e.entrySet()) {
            if (x.getKey().equals("id")) {
                map.put("sample_id", (String) x.getValue());
            } else if (x.getKey().equals("display")) {
                map.put("sample", (String) x.getValue());
            } else {
                map.put((String) x.getKey(), (String) x.getValue());
            }
        }

        return map;
    }).collect(Collectors.toList());