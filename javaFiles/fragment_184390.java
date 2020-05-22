private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) 
{                                         
    try {
    BufferedReader br = new BufferedReader(new 
     FileReader("zam.txt"));

    String r;
    do{
        r = br.readLine();
        if(r!=null){
            String [] sline=r.split(";");
            table.addRow(sline);                
        }
    }while(r!=null);

    br.close();
    } catch (IOException e) {
    }
}