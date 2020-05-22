public class SendungsCellRenderer extends JPanel implements ListCellRenderer {

    private EmptyBorder eb = new EmptyBorder(5, 2, 5, 2);
    private LineBorder lb = new LineBorder(new Color(255,255,255), 5);

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        this.removeAll();
        uiSendungsbutton p = (uiSendungsbutton) value;
        if(isSelected){
            this.setBackground(new Color(200,200,250));
            this.setBorder(new CompoundBorder(lb, new StrokeBorder(new BasicStroke())));
        }else{
            this.setBackground(new Color(252,252,252));
            this.setBorder(lb);
        }
        this.setLayout(p.getLayout());
        this.add(p.getNamePnl(),BorderLayout.NORTH);
        this.add(p.getKdnrPnl(), BorderLayout.CENTER);
        return this;
    }
}