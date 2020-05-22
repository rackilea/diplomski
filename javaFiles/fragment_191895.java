int result = -1;
do {
    result = menu.menu();
    if(result == 1) {
        menu.newSquare();
    }
    if (result == 2) {
        JOptionPane.showMessageDialog(null, menu.format());
    }
} while(result == 1 || result == 2);