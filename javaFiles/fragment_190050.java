List<List<Pos>> result = new ArrayList<>();
List<Pos> part = new ArrayList<>();
for(Pos pos : listPos){
    if(pos.getBeforeChangement().equals(".") || pos.getAfterChangement().equals(".")){
        result.add(part);//If the condition is correct then add the sub list to result list
        part = new ArrayList<>();// and reinitialize the sub-list
    } else {
        part.add(pos);// else just put the Pos object to the sub-list
    }
}
//Just in case the listPos not end with "." values then the last part should not be escaped
if(!part.isEmpty()){
    result.add(part);
}