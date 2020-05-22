for (i=0; i <tickets.size(); i++){
  if(tickets .get(i).getPurchased()== false){
    theDateArray.add(tickets.get(i).getDate());
  }
}
for(int f=0; f<theDateArray.size();f++){
  System.out.println(theDateArray.get(f)+ " ");
}