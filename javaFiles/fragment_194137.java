class User<PK> implements Entity<PK> {
    private PK pk;

    @Override
    public PK getPk() { return pk; }

    @Override
    public void setPk(PK pk) { this.pk = pk; }  
}