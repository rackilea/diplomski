List<HashMap<String, Integer>> countsList = new ArrayList<>();
    searchTexts.forEach(searchText ->{
         countsList.add(new HashMap<String, Integer>()
         {{put(searchText,countMap.get(searchText.toUpperCase()) == null ? 0 : countMap.get(searchText.toUpperCase()));}});
    });
    Map<String, List<HashMap<String, Integer>>> response = new HashMap<>();
    response.put("counts", countsList);