private void RunGameButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
    try
    {
       //Basic game launching command.
       StringBuilder sb = new StringBuilder("cmd.exe /C start C:\\mygame\\game.exe");
       if(chkNoMonsters.isSelected())
       {
           //Add the No Monsters Flag
           sb.append(" -nomonsters");
       }
       if(CheatsBox.isSelected())
       {
           //Add the Cheats Flag
           sb.append(" +SV_CHEATS 1");           
       }

       //Launch the game
       Process process = Runtime.getRuntime().exec(sb.toString());
    }
    catch(IOException e)
    {
        //Log Error
    }
}