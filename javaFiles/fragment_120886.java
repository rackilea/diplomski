public class DoubleRenderer extends DefaultTableCellRenderer {

DecimalFormat df;

public DoubleRenderer(DecimalFormat df) {
    this.df = df;
    this.setHorizontalAlignment(JLabel.CENTER);
    this.setBackground(Color.lightGray);
    this.df.setParseBigDecimal(true);
}

@Override
protected void setValue(Object value) {
    setText((value == null) ? "" : df.format(value));
}
 }