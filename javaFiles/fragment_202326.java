Mouse(String mj) {
        super(mj);
        addWindowListener(new mywa(this));

        addWindowListener(this);//error , Parameter should be a WindowListener object
        setSize(500, 500);
        setVisible(true);
    }