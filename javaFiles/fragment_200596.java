int len = stageActors.size;
for(i=0; i<len; i++){
    Actor a = stageActors.get(i);
    if(a.getName().equals("myactor")){
        //a is your Actor!
        break;
    }
}