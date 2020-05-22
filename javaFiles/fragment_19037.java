private class XButton extends Button {
    public XButton(String label) { 
        super(label); 
        setRenderer(new Button.FlatButtonRenderer()); 
    } 
}