public void paintCheckBoxBackground(SynthContext context, Graphics g, int x, int y, int w, int h){

    AbstractButton c = (AbstractButton) context.getComponent();
    String text = c.getText();
    Icon icon = c.getIcon();
    if (icon == null){
        icon = context.getStyle().getIcon(context, "CheckBox.icon");
    };        
    int iconTextGap = c.getIconTextGap();       

    Rectangle componentRect = new Rectangle();
    Rectangle iconR = new Rectangle();

    Insets insets = new Insets(0, 0, 0, 0);
    if (context.getRegion().isSubregion()){
        insets = context.getStyle().getInsets(context, insets);
    }
    else{
        insets = context.getComponent().getInsets(insets);
    }

    componentRect.x = insets.left;
    componentRect.y = insets.top;
    componentRect.width = c.getWidth() - (insets.left + insets.right);
    componentRect.height = c.getHeight() - (insets.top + insets.bottom);

    if (icon != null){
        iconR.x += componentRect.x;
        iconR.y += componentRect.y;
        iconR.width = icon.getIconWidth();
        iconR.height = icon.getIconHeight();

        g.setColor(Color.GREEN);
        g.fillRect(iconR.x, iconR.y, iconR.width, iconR.height);
    }
    if (text != null){
        g.setColor(Color.RED);
        int textPos = iconR.x + iconR.width + iconTextGap;
        g.fillRect(textPos, iconR.y, c.getWidth() - insets.right - textPos, componentRect.height);            
    }
}