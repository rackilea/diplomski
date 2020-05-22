class SubOne extends SuperOne {

    public SubOne(SuperOne superOne) {
        super.setId(superOne.getId());
        super.setName(superOne.getName());
    }