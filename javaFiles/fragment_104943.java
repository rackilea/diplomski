if(sArray[i].equals("(") && sArray[i+1].equals(")")){
            System.out.println("False");
            return;
        }
        if(sArray[i].equals(")") && sArray[i+1].equals("(")){
            System.out.println("False");
            return;
        }