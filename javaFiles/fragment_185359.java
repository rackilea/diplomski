public TextUpper(Integer length){
        super();
        setMaxLength(length);   
        setImmediate(true);
        setTextChangeEventMode(TextChangeEventMode.EAGER);
        addTextChangeListener(this);
    }

    public TextUpper(){
        super(); 
        setImmediate(true);
        setTextChangeEventMode(TextChangeEventMode.EAGER);
        addTextChangeListener(this);
    }