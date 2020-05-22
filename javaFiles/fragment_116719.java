for(int i=0; i<listTeams.size();i++){
    for(int j=i+1;j<listTeams.size();j++){
           for(int k=j+1;k<listTeams.size();k++){
                String str = listTeams.get(i)+listTeams.get(j)+listTeams.get(k);
                lines.put(str,new ArrayList<String>());                 
                }
             }              
           }