public static void main(String[] args) throws Exception {
    String stud_Name = "";
    String name_list = "";
    while(true) {
        stud_Name = JOptionPane.showInputDialog("Enter Student name. Type 'DONE' when finished.");
        if (stud_Name.equals("")) {
            JOptionPane.showMessageDialog(null,"Please enter a name.");
            continue;
        }
        if (stud_Name.equalsIgnoreCase("DONE")) {
            // ignore case
            break;
        }
        name_list += stud_Name + "\n";
    }
    JOptionPane.showMessageDialog(null, name_list);
}