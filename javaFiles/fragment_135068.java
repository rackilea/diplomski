JSONArray arr = //your data object
    JSONArray newArr = new JSONArray();
    arr.stream().forEach(el -> {
        Integer val = (Integer) ((JSONObject) el).get("building");
        if (((List<Integer>) newArr.parallelStream().map(obj -> (Integer) ((JSONObject) obj).get("building"))
                .filter(obj -> obj == val).collect(Collectors.toList())).isEmpty()) {
            newArr.add(el);
        }
    });