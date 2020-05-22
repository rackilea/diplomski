public void actionPerformed(ActionEvent e)
{
   String arg = e.getActionCommand();

  //user clicks the sort by combo box
  if(e.getSource() == fieldCombo)
    {
    switch(fieldCombo.getSelectedIndex())
    {
        case 0:
            sort(title);
            break;
        case 1:
            sort(studio);
            break;
        case 2:
            sort(year);
            break;
    }//end swictch
    } //end if

    //user clicks exit on file menu
    if (arg.equals("Exit"))
    System.exit(0);
    //user clicks insert new dvd on edit menu
    if (arg.equals("insert"))
    {
       String newTitle = JOptionPane.showInputDialog(null, "Please enter the moive's title");
       String newStudio = JOptionPane.showInputDialog(null, "Please enter the studio for" + newTitle);
       String newYear = JOptionPane.showInputDialog(null, "Please enter the year for " + newTitle);

        //Enlarge arrays
        title = enlargeArray(title);
        studio = enlargeArray(studio);
        year = enlargeArray(year);

        //add to arrys
        title[title.length-1] = newTitle;
        studio[studio.length-1] = newStudio;
        year[year.length-1] = newYear;

        //call to sort method
        sort(title);
        fieldCombo.setSelectedIndex(0);

    }//end if

    //user clicks title on search submeu
    if(arg.equals("title"))
     search(arg,title);

 //user clicks title on studio submeu
    if(arg.equals("studio"))
        search(arg,studio);

    //user clicks title on year submeu
    if(arg.equals("year"))
        search(arg,year);

}//end of actionPerfomed method