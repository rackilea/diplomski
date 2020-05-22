String s[]={"a","b","c","-","g","t","-","q","-","a","s","d","-","a","b","y"};

    String split = "-";

    ArrayList<String> list = new ArrayList<String>();
    String temp = "";

    for(int i = 0 ; i < s.length ; i++){
        if(s[i].equals(split)){
            list.add(temp);
            temp = new String();
        }else{
            temp += s[i];
        }
    }

    String array[] =  list.toArray(new String[list.size()]);

    for(String str : array){
        System.out.println(str); // output : abc;gt;q;asd;
    }