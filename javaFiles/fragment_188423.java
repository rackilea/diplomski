String json = "[{id:1,label:2,code:3},{id:4,label:5,code:6}]";
    List<Item> items = new Gson().fromJson(json, new TypeToken<List<Item>>(){}.getType());

    List<List<String>> listOfLists = new ArrayList<>();
    for (Item item : items) {
        List<String> subList = new ArrayList<>();
        subList.add(item.getId());
        subList.add(item.getLabel());
        subList.add(item.getCode());
        listOfLists.add(subList);
    }

    System.out.println(listOfLists);  // [[1, 2, 3], [4, 5, 6]]