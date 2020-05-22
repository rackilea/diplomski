try{
     //specify the name of the output..
     FileWriter fstream = new FileWriter("output.pgm");
     //we create a new BufferedWriter
     BufferedWriter out = new BufferedWriter(fstream);
     //we add the header, 128 128 is the width-height and 63 is the max value-1 of ur data
     out.write("P2\n# CREATOR: XV Version 3.10a  Rev: 12/29/94\n128 128\n63\n");
     //2 loops to read the 2d array
     for(int i = 0 ; i<tabDecode.length;i++)
        for(int j = 0 ; j<tabDecode[0].length;j++)
            //we write in the output the value in the position ij of the array
            out.write(tabDecode[i][j]+" ");
     //we close the bufferedwritter
     out.close();
     }
catch (Exception e){
     System.err.println("Error : " + e.getMessage());
}