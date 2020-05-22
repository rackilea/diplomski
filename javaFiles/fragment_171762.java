String scoreSplit[] = A[i].split(":");
if (scoreSplit.length() == 2){
   int num = Integer.parseInt(A[i].split(":")[1]);
}
else{
   system.out.println("Bad apple with "+ scoreSplit[0]);  //some kind of logging
}