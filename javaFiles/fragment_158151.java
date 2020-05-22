public static Bunz getInstance(){
        if (instance == null){
            instance = new Bunz();
            instance.setBunz(50);
            instance.setMoney(0);
        }
        return instance;
    }