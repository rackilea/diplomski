String str1 = null; 
for (int row=0; row<dfsa.length; row++) {

    System.out.print("\tstate " + row +": ");   
    String line = "";
    for (int col=0; col<dfsa[row].length; col++) {  
        for (int i=0; i<dfsa_StateList.size(); i++) { // traverse thru dfsa states list                     
            if (dfsa_StateList.get(i).equals(dfsa[row][col])) {
                str1 = alphabetList.get(col)+ " " + i + ", ";
                line += str1;
            }
        }                   
    }    
    line = line.length() > 0 ? line.substring(0, line.length() - 2) : "None";
    System.out.println(line)       
}