titleList.stream()
        .forEach(titleMap ->
            combineList.addAll(
                codeList.stream()
                    .filter(codeMap -> titleMap.get("ID").equals(codeMap.get("ID")))
                    .map(codeMap -> {
                      Map<String, Object> tempMap = new HashMap<>();
                      tempMap.put("ID", titleMap.get("ID"));
                      tempMap.put("NAME", titleMap.get("NAME"));
                      tempMap.put("ID", codeMap.get("ID"));
                      tempMap.put("AGE", codeMap.get("AGE"));
                      return tempMap;
                    })
                    .collect(Collectors.toList())
            )
        );