public static void listWineTypes(wineTypes[][]) {  //void return
       listarray[][] = wineTypes[][]; 
      for(i=0; i<listarray.length;i++){  //change this
        for(int j=0; j<listarray[i].length; j++){ //and this
          JOptionPane.showMessageDialog(wineTypes[i][j]); //this will print out each wine in the list.
}