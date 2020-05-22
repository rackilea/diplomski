String WA_SLA = "", REQ_SLA = "";
int Va_WA_SLA = 0, Va_REQ_SLA = 0;
  if(WA_SLA.equalsIgnoreCase("9*5 SBD"))
  {
      Va_WA_SLA = 1;
  }
  if(REQ_SLA.equalsIgnoreCase("9*5 NBD"))
  {
      Va_REQ_SLA = 0;
  }
      if(Va_WA_SLA > Va_REQ_SLA)
  {
      JOptionPane.showMessageDialog(frame,"Warranty SLA is Higher than Requested SLA " ,null, JOptionPane.INFORMATION_MESSAGE);
  }