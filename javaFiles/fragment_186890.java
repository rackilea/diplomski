public AppWindow(String user, int ID) {
    this.ID = ID;
    this.user = user;
    setSize(500, 500);
    setTitle("Books");

    setLayout(new BorderLayout());
    greetText.setText("Hi "+user+" here are your books:");
    add(greetText, BorderLayout.NORTH); 

    JTable table = askData();  
    scrollPane.setViewportView(table);
    panel.add(scrollPane);
    add(panel, BorderLayout.CENTER);

    panel2.add(newBook);
    panel2.add(deleteBook);
    panel2.add(changeBook);
    add(paneel2, BorderLayout.SOUTH);

    newBook.addActionListener(this);

    setVisible(true);
}

private JTable askData() {
    DataAsker asker = null;
    try {
        asker = new AndmeKysija(ID);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return asker.giveTable();
}

public static void main(String[] args){
    AppWindow window = new AppWindow("Name", 2);
}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == newBook){
        new BookAdded(ID);
        JTable table = askData();  
        scrollPane.setViewportView(table);
    }   
}