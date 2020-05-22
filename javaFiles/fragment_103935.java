public class nextgui extends Jframe {
        public int rungui() {
            int confirmCombat = JOptionPane.showConfirmDialog(null, "Are you sure you would like to set your main trait as Combat?", "Confirm Combat", JOptionPane.YES_NO_OPTION); { 
            if (confirmCombat == 0) { 
                this.setVisible(false); 
                gui mainJframe = new gui(); 
                mainJframe.setVisible(true); 
            } 
        } 
            return 1; 
}