JSONArray arr = new JSONArray();
arr.put(false);
arr.put(true);
arr.put(false);

//JSONArray is a list of objects
boolean b = IntStream.range(0, arr.length())
        .anyMatch(arr::getBoolean);

System.out.println(b);