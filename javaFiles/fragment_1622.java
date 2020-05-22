public JPanel create_Content_Pane()
{
    JPanel TotalGUI = new JPanel();

    TotalGUI.add(remove = new JButton("Remove"));
    remove.addActionListener(this);

    TotalGUI.add(add = new JButton("Add")); <- this crashes when selected
    add.addActionListener(this);

    //TotalGUI.add(create_PersonPnl()); <- works just fine

    return TotalGUI;
}