void setButtons() {
    admin = new JButton("Admin");
    captain = new JButton("Captain");
    grades = new JButton("Grades");

    getContentPane().setLayout(new FlowLayout());
    add(admin);
    add(captain);
    add(grades);
-- Here -->    setAction();
}