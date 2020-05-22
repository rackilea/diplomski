int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "Metric or Imperial?", //Object message,
                               "Choose an option", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               {"Metric","Imperial"}, //Object[] options,
                               "Metric");//Object initialValue 
if(choice == 0 ){
   //Metric was chosen
}else{
   //Imperial was chosen
}