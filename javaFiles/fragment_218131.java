String[][] data= new String[][] {
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "VIEW BUTTON"},
        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "VIEW BUTTON"}};
String[] col = new String[] {
        "Last Name", "First Name", "Middle Initial", "Phone Number", 
        "Email", "Project Title", "Project Description", "Amount", 
        "Date Approved", "Date Completed", "College", "Faculty Mentor Name", 
        "Co Grantee", "Major", "Travel Required", "Travel Purpose", 
        "Travel Cost", "Travel Start Date", "Travel End Date", "View"};

 JXTable table = new JXTable(data,col);
 table.setVisibleColumnCount(10);
 table.setHorizontalScrollEnabled(true);
 JScrollPane pane = new JScrollPane(table);
 JComponent comp = new JPanel(new BorderLayout());
 comp.add(pane);