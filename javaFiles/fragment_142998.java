List<Integer> list = new ArrayList<Integer>(map.keySet());

for(int i = 0; i < list.size(); i++) {
    if(i == 0) builder.append(0);
    else builder.append(list.get(i) - list.get(i-1));
}