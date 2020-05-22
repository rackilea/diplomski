private void RunGameButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
    try
    {
       if(chkNoMonsters.isSelected())
       {
           Process process = Runtime.getRuntime().exec("cmd.exe /C start C:\\mygame\\mygame.exe -nomonsters");
       }
       else
       {
           Process process = Runtime.getRuntime().exec("cmd.exe /C start C:\\mygame\\game.exe");    
       }
    }
    catch(IOException e)
    {
        //Log Error
    }
}