public class MultiplerActionListener implements ActionListener {
    private int[] values;
    private JLabel label;
    public MultiplerActionListener(JLabel label, int... valuesToMultiple) {
        values = valuesToMultiple;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent event) {        
        int answer = 1; 
        StringBuilder sb = new StringBuilder(64);
        for (int value : values) {
            if (sb.length() > 0) {
                sb.append(" x ");
            }
            sb.append(value);
            answer *= value;
        }
        sb.append(" = ");
        sb.append(answer);
        label.setText(sb.toString());
    }
}