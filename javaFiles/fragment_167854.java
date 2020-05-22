@Override
    public Swimmers clone() throws CloneNotSupportedException{
        Swimmers swp = (Swimmers)super.clone();
        swp.swimmers = new ArrayList<>(swimmers);
        return swp;
    }