Userdatabase = FirebaseDatabase.getInstance();
FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
Userdatabaseref = Userdatabase.getReference().child("Threads 
           Users");            
DatabaseReference CurrentUser = Userdatabaseref.child("Threads 
          Users").child(firebaseAuth.getCurrentUser().getUid());
Map<String, Object> userdata = new HashMap<>();
userdata.put("userfirstname", Fname);
userdata.put("userlastname", Sname);
userdata.put("userdateofbirth", DOB);
userdata.put("useraddress", Add);
userdata.put("userpostcode", Ptd);
userdata.put("usercardnumber", Cnumber);
userdata.put("usercardexpirydate", Cdate);
userdata.put("userccvnumber ", CCV);

CurrentUser.updateChildren(userdata);