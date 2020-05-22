class Credentials implements ICredentials{

    public void update(ICredentials updatedCredentials){
         updatedCredentials.updateParam(this);
    }

    @Override
    public void updateParam(Credentials credentialsToUpdate){
         credentialsToUpdate.name= name;
         credentialsToUpdate.surname = surname;
         credentialsToUpdate.email= email;
    }
}