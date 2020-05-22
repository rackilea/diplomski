System.out.println("**** Flight "+flightCode[0]+" ****");
for(int j=0 ; j<seat[0].length ; j++){
    for(int k=0; k< seat[0][j].length;k++){     
        if(k%3 == 0){
            System.out.println(seat[0][j][k]);
        }
        else{
            System.out.print(seat[0][j][k]);
        }
    }
}