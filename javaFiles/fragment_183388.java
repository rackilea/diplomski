private SharedSpace sharedSpace;

    private Integer value;

    public Consumer(SharedSpace sharedSpace) {
        super();
        this.sharedSpace = sharedSpace;
    }

    public SharedSpace getSharedSpace() {
        return sharedSpace;
    }

    public void setSharedSpace(SharedSpace sharedSpace) {
        this.sharedSpace = sharedSpace;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void run() 
    {

        try {
            setValue(sharedSpace.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }