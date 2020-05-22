for(int i = 0; i<dispense.size();i++) {
        System.out.println(dispense.get(i).equals(k));
        if(dispense.get(i).equals(k)){
            dispense.remove(i);
            break;
        }
    }