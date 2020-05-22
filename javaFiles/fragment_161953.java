class PanelFirst {

    private static FlowPanel firstPanel;

    public PanelFirst (){};

    public FlowPanel createPanelFirst(){
        firstPanel = new FlowPanel();
        firstPanel.add(MyButton.createMyButton());
        return firstPanel;
    }   
}

class PanelSecond  {
    private static FlowPanel secondPanel;

    public PanelSecond(){};

    public FlowPanel createPanelSecond(){
        secondPanel= new FlowPanel();
        secondPanel.add(MyButton.createMyButton());
        return secondPanel;
    }   
}