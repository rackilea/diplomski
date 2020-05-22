class SubOne {

    private SuperOne superOne;

    public SubOne(SuperOne) {
        this.superOne = superOne;
    }

    public String getId() {
        return this.superOne.getId();
    }

    public String getName() {
        return this.superOne.getName();
    }

    public String setId(String id) {
        return this.superOne.setId(id);
    }

    public String setName(String name) {
        return this.superOne.setName(name);
    }

    ///////////////

    public SubOne getData(String id){
        SuperOne data = someDao.getData(String id)
        return new SubOne(data);  
    }