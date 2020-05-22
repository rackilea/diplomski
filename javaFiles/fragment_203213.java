int amount; //amount goes out of the `findAdd()`
int useranswer;
for (int i=0; i<6; ++i) {
    useranswer = findAdd();
    if (useranswer == JOptionPane.YES_OPTION) { //quit?
        return; //exit?   
    }
}
JOptionPane.showMessageDialog(null,"LEVEL ONE COMPLETE!", "LEVEL 1", JOptionPane.INFORMATION_MESSAGE);
JOptionPane.showMessageDialog(null,"Cash on Hand: $ " + amount, "Cash", JOptionPane.INFORMATION_MESSAGE);