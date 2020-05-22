String[] parts = numbers.split("\\s+");
int counter = 0;                    //counter to track position in string of data  
for (int i = 0; i < 20; i++) {      //cycle rows  
    for (int y = 0; y < 20; y++) {  //cycle columns  
      String s = parts[counter];
      byte b = (byte)(Integer.parseInt())
      array[i][y] = b;    
      counter++;    //increase place in data string                                
    }  
}