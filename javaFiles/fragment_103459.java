if(transfer.hasNextDouble()){
      Array[i].setDouble(transfer.nextDouble());
    }else{ 
    System.out.println("expecting a double, but got"+transfer.getNext());
    }

    if(transfer.hasNextLong()){
       Array[i].setLong(transfer.nextLong());
    }else{
    System.out.println("expecting a Long, but got"+transfer.getNext());
    }...