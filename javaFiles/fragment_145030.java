Map<String, Boolean> map = new HashMap<>();
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i = 0; i < str.length(); i++) {
        map.put(str.substring(i, i+1), true);
    }
    System.out.println(map.keySet());