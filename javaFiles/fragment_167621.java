int i = 0;
while ((line = br.readLine())!= null){ 
    temp = line.split(" "); 
    for (int j = 0; j<myarray[i].length; j++) {    
        myarray[i][j] = Integer.parseInt(temp[j]);
    }
    i++;
}