ArrayList<Integer> percentList = new ArrayList<>(Arrays.asList(20,30,40,30,20,30));
    ArrayList<Integer> amountList = new ArrayList<>(Arrays.asList(50,60,100,70,120,90));
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i = 0; i < percentList.size();i++)
    {
        int percent = percentList.get(i);
        int amount = amountList.get(i);
        map.put(percent,(map.containsKey(percent) ? map.get(percent) : 0) + amount);
    }

    ArrayList<Integer> percentUniqueList = new ArrayList<>(map.keySet());
    ArrayList<Integer> amountUniqueList = new ArrayList<>(map.values());