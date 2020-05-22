String name;
do {
    name = JOptionPane.showInputDialog(null, "Please type a name for your file");
    if(name == null) { //user hit cancel, break the loop
        break;
    }
} while(name.isEmpty());