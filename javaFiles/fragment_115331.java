private class CalcButtonListener implements ActionListener 
 {
    public void actionPerformed(ActionEvent e)
    {
           try{
                  grossChildTicketSold = (textBoxPanel.getChildCost() *   textBoxPanel.getChildTotal()); 
                  grossAdultTicketSold = (textBoxPanel.getAdultCost() *   textBoxPanel.getAdultTotal());
                  netChildTicketSold = (PERCENT_TOTAL * grossChildTicketSold);
                  netAdultTicketSold = (PERCENT_TOTAL * grossAdultTicketSold);
                  grossRevenue = (grossAdultTicketSold + grossChildTicketSold);
                  netRevenue = (PERCENT_TOTAL * grossRevenue);
              }
              catch(Exception a)
              {
              System.out.println("Fields are not completely filled out or letters may have   been enter");
          }
           outPut.setText(""); //clear text to JTextArea
           outPut.append("Gross revenue for adult tickets sold: " +      grossAdultTicketSold + "\n");
           outPut.append("Net revenue for adult tickets sold: " + netAdultTicketSold + "\n");
           outPut.append("Gross revenue for child tickets sold: " + grossChildTicketSold   + "\n");
           outPut.append("Net revenue for child tickets sold: " + netChildTicketSold +    "\n");
           outPut.append("Gross revenue: " + grossRevenue + "\n");
           outPut.append("Net revenue: " + netRevenue + "\n");
    }  
 }