String str = "aaabbcc";
    char c;
    ArrayList<String>count=new ArrayList();

    for(int i = 0; i < str.length(); i++){
    if(!count.contains(str.charAt(i)+"")){
    count.add(str.charAt(i)+"");
    }
    }