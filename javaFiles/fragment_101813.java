//This is the arrays holding the category names and colors.
String[] cati = {"Ingen", "Matställen", "Skolor", "Kyrkor", "Kollektiv trafik"};
Color[] colors = {Color.WHITE, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK};

// This is a inner class in the super class. 
class kategoriFärg implements ListSelectionListener {   
        public void valueChanged(ListSelectionEvent event) {

        if (kategorLista.getSelectedIndex() > -1) {
            System.out.println("does this work?");
            syd.setBackground(colors[kategoriLista.getSelectedIndex()]);
            //syd is the south JPanel
        }
    }
}