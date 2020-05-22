private void writeResume(com.sun.star.text.XText xText, com.sun.star.text.XTextCursor xTCursor) {
    TestData resume = new TestData();
    List<Company> companies = resume.getCompanies();
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.changeStyle(xTCursor, "Heading 1");//if this line is NOT here then will default to a custom style
    xText.insertString(xTCursor, "Professional Experience\n\r", false);
    xTCursor.collapseToEnd();
    //xText.insertControlCharacter(xText, com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, false);
    this.changeStyle(xTCursor, "Heading 2");//if this line is NOT here then will default to a custom style
    Company company = companies.get(0);
    String date = dformat.format(company.getStartDate().getTime()) + " - " + dformat.format(company.getEndDate().getTime());
    xText.insertString(xTCursor, company.getName() + "," + company.getLocation() + "\t" + date + "\r", false);
    xText.insertString(xTCursor,"Title\r", false);

    this.changeStyle(xTCursor, "Heading 3");//if this line is NOT here then will default to a custom style
    xText.insertString(xTCursor, "Test Point 1\r", false);
    this.changeStyle(xTCursor, "Heading 3");
    xText.insertString(xTCursor, "Test Point 2\r", false);
    this.changeStyle(xTCursor, "Heading 3");
    xText.insertString(xTCursor, "Test Point 3\r", false);
}