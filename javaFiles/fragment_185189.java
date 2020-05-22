AlternateNew.add(alternate[0]);
        for(int i=1;i<keyword.length;i++){
            if(keyword[i]==(keyword[i-1])){
                AlternateNew.add(alternate[i]);
            }else if(!(keyword[i]==(keyword[i-1]))){
                AlternateNew.add(alternate[i]);
            }
        }