File file = new File(stafffile);
Staff tmpstaff = null; // or simpler, Staff tmpstaff;
try {
   ...
   while((tmp = inputfile.readLine()) != null){
     tmpstaff = new Staff();
     ...