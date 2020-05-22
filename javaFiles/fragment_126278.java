FuelData tempFD = null;
while(rs.next()){
  int temp = rs.getInt("alarmType");

  if(temp == 60 ){
     //print or add to list tempFD
     tempFD = null; 
  } else {
     tempFD = new FuelData();
  }

}