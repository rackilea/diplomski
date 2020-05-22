Statement stmt = null; // Look ma, I'm null
//       rs=(ResultSet) dlFollowUp.getFollowUpList();
//       getFollowUplist();
ResultSet rs = null;
// Look ma, I'm still null
rs = stmt.executeQuery("SELECT id,customer,phone,product,lastsoldqty,consumption,lastsaledate,deliverydate,remark1,remark2,stock,invoiceno FROM followup");