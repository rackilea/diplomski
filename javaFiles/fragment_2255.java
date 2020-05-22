String sequence = "ABCDEABCACBDDECF";

char[] chars = sequence.toCharArray();
int i = 0;
Map<String,Integer> map = new HashMap<String,Integer>();
while(i < chars.length - 2){
    String pattern = "" + chars[i] + chars[i+1] + chars[i+2];
    System.out.println(pattern);
    Integer population = map.get(pattern);
    if(population == null){
        population = 1;
    }else{
        population++;
    }
    map.put(pattern, population);

    i++;
}

System.out.println(map);