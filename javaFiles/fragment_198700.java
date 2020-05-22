List<String[]> dogList = new ArrayList<String[]>();
    dogList.add(new String[] { "id_tag", "breed", "rank", "nickname"});
    dogList.add(new String[] { "t4639", "Akita", "First", "Marshal"});
    dogList.add(new String[] { "t4638", "Akita", "First", "Tom"});
    dogList.add(new String[] { "t4637", "Beagle", "First", "Eddy"});
    dogList.add(new String[] { "t4636", "Beagle", "Second", "Franky"});
    List<String[]> dogTotal = new ArrayList<String[]>();
    HashMap<String,Integer> map = new HashMap<>();
    for(int i=1;i<dogList.size();i++){
        String key = dogList.get(i)[1]+"_"+dogList.get(i)[2];

        map.put(key,map.get(key)==null?1:map.get(key)+1);
    }
    for(Map.Entry<String,Integer> entry : map.entrySet()){
        String key = entry.getKey();
        String breedRank[] = new String[3];
        String getBackValues[] = key.split("_");
        breedRank[0] = getBackValues[0];
        breedRank[1] = getBackValues[1];
        breedRank[2] = String.valueOf(entry.getValue());
        System.out.println(breedRank[0]+ ", " + breedRank[1]+","+ breedRank[2]);
        dogTotal.add(breedRank);
    }
    System.out.println(dogTotal);