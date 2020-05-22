public class TriStateActionListener implements ActionListener{
    final protected Icon icon;

    public TriStateActionListener(Icon icon){
        this.icon=icon;
    }

    public static Boolean getState(javax.swing.JCheckBox cb){
        if (cb.getIcon()==null) return null;
        if (cb.isSelected()) return true;
        else return false;
    }

    public void actionPerformed(ActionEvent e) {
        javax.swing.JCheckBox cb=(javax.swing.JCheckBox)e.getSource();
        if (!cb.isSelected()){
            cb.setIcon(icon);
        }
        else if (cb.getIcon()!=null){
            cb.setIcon(null);
            cb.setSelected(false);
        }
    }
}