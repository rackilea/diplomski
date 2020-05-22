public void createProfile(Profile user) throws PEException {
    Vector<Profile> p = new Vector<Perfil>(); //not being used...

    if (repository.search(user.getUsername()) == null) {
        try{
            repository.register(user);
        }catch(UJCException e){
            e.printStackTrace();
            throw new PEException(user.getUsername());
        }
    }
    else {
        throw new PEException(user.getUsername());
    }
}


public void register(Profile user) throws UJCException
{
    if (this.search(user.getUsername()) == null) {
        this.users.add(user);
    }
    else {
        throw new UJCException(user.getUsername());
    }
}