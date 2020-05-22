HumanCoverageData hcd = new HumanCoverageData();
for (Coverage c : sec.getCoverage()){

     hcd.setFirstName(c.getUser_name().split(",")[0]); 
     hcd.setLastName(c.getUser_name().split(",")[1]); 
     hcd.setPhoneNumber(c.getPhone_number()); 
     hcd.setRoleCode(c.getRolecode()); 
     hcd.setRoleDescription(null); 
     hcd.setUserId(c.getUser_id()); 

     HumanCoverageDataList.add(hcd);
}