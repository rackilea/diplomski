Class User{

    public User(Response response) {        
        setName(response.getName());
        setId(response.getId());
        setType(response.getType());
        setDesignation(response.getDesignation());
    }

}