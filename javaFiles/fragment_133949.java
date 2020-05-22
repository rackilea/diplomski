List<String> altered = new ArrayList<>();
    for(int i=0; i<list.size(); i++){
        int start = i;
        int size = 1;
        int end = start;
        if(i<list.size()-2){
            end = start+1;
            while(list.get(end) == list.get(end-1)+1){
                size++;
                end++;
                if(end >= list.size())
                    break;
            }
        }
        if(size >=3){
            altered.add(list.get(start)+"-"+list.get(end-1));
            i = end-1;
        }
        else
            altered.add(""+list.get(i));
    }
    System.out.println(altered);