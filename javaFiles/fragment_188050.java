public void addclass(int a) {
    String s=(String) mainCB.getItemAt(a); //mainCB is variable name of combobox
    B subpanel2=new B(); //added the class
    jTabbedPane1.add(s,subpanel2); //added new tab which is the new class
    subpanel2.heading(s); //heading is the function in Class B
}