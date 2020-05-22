public Class Xyz {    

    private List<Daemon> daemons;

    @Autowired
    public void setDaemons(List<Daemon> daemons){
        this.daemons = daemons;
    }

}