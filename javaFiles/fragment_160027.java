public static void main(String[] args) {
        String choice="";
        Counter counter= new Counter(0);
        do{
           choice = JOptionPane.showInputDialog("message");
           switch (choice) {
            case click:
            counter.click();
            break;
                case getValue:
            JOptionPane.showMessageDialog(null,counter.getValue());
            break;
        default:
            break;
        }  
        }while(!choice.equals("close");      
    }