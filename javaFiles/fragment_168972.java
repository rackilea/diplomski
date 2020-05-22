interface HasHome {
    Building getHome();
}

class Dad implements HasHome {
    protected Building home;

    public Dad() {
        this.home = new Building();
    }

    @Override
    public Building getHome(){
        return this.home;
    }
}

class Son implements HasHome { // Or extends Dad
    protected Shack home;

    public Son () {
        super();
        this.home = new Shack();
    }

    @Override
    public Shack getHome() {
        return home;
    }
}