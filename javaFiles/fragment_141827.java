private JPanel panel2() 
{
    //JPanel newPanel = new JPanel(); don't create a new panel!
    //CreateAPanel(newPanel, LeftPanel,RightPanel,splitPaneH, panelTop,panelBottom);
    //instead do this:
    JPanel newPanel = CreateAPanel(newPanel, LeftPanel,RightPanel,splitPaneH, panelTop,panelBottom);
    JLabel label = new JLabel ("lalala");
    LeftPanel.add(label,BorderLayout.CENTER);
    return newPanel;
}