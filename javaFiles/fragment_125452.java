@Override
    public Pet getPet(int petId) {
    for (Pet _pet : datas) 
            if (_pet.getId() == petId) 
        return pet;
    return null;
    }

    @Override
    public Pet removePet(int petId) {
    Pet pet =null;
    if((pet= getPet(petId))!=null){
        datas.remove(pet);
    return pet;
    }
    return null;
    }

    @Override
    public int updatePet(int petId, Pet pet) {
    if(petId<datas.size())
    datas.set(petid,pet);
return pet.getId();
    }