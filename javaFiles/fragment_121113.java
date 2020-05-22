int i = 0;
while ((line = br.readLine()) != null){

    String[] temp = line.split(",");
    if(temp.length == 3)
        mushroom[i] = temp[0];
        weight[i] = Integer.parseInt(temp[1]);  
        cooking[i] = temp[2];
    } else {
        // some error handling
    }         
    i++;
 }