for (int i = 0; i < str.length(); i++) {
    c=str.charAt(i);
       for(int j=0;j<count.size();j++){
           if(count.get(j).equals(c+"")){
               dd[j]++;
           }
       }
    }

    String newS="";
    for(int i=0;i<count.size();i++){
        newS+=count.get(i)+dd[i];
    }