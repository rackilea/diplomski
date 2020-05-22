boolean isGroup=false;
while(line = br.readline() != null){
    if(line.equals("Group1"){
      isGroup=true;
    }
    if(line.equals("}") && isGroup)
      isGroup=false;
    if(isGroup){
      //read line and check whether it is null or not
      list.add(line);
    }
 }