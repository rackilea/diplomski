ArrayList<Integer> first = new ArrayList<Integer>(Arrays.AsList(100,100,100,100,100));
ArrayList<Integer> second = new ArrayList<Integer>(Arrays.AsList(50,35,25,45,65));
ArrayList<Integer> third = new ArrayList<Integer>();

for(int i = 0; i < first.size(); i++) {
      third.add(first.get(i));
      third.add(second.get(i));
}