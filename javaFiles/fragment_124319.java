public static RandomClass showPopupBox(List<RandomClass> list)
{
    JRadioButton[] rdoArray = new JRadioButton[list.size()];
    ButtonGroup group = new ButtonGroup();
    JPanel rdoPanel = new JPanel();
    for(int i = 0; i < list.size(); i++)
    {
        rdoArray[i] = new JRadioButton(list.get(i).toString());
        group.add(rdoArray[i]);
        rdoPanel.add(rdoArray[i]);
    }
    rdoArray[0].setSelected(true);

    JOptionPane pane = new JOptionPane();
    int option = pane.showOptionDialog(null, rdoPanel, "The Title",
                                       JOptionPane.NO_OPTION,
                                       JOptionPane.PLAIN_MESSAGE,
                                       null, new Object[]{"Submit!"}, null);

    if(option == 0)
    {
        for(int i = 0; i < list.size(); i++)
            if(rdoArray[i].isSelected()) return list.get(i);
    }
    return null;
}