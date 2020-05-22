if(wbListPK.getRid()!=0){
  criteria.add(Expression.eq("id.rid", wbListPK.getRid()));
}
if(wbListPK.getSid()!=0){
  criteria.add(Expression.eq("id.sid", wbListPK.getSid()));
}