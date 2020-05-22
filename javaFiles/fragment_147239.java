public static String readin(){
    boolean error=false;
    do{ 
        string stringin;
        stringin=JOptionPane.showInputDialog(null,"Please enter a number");
        switch (stringin.length()){
            case 0: JOptionPane.showMessageDialog(null, "Error Please repeat");
                error=true;
                break;
            case 1: return stringin;
        } 
    } while (error);
    return null;
}