@Entity
class ItemEntity {

    @Transient
    private ItemEntity previousState;

    @PostLoad
    private void setPreviousState(){
        previousState = new ItemEntity();
        //copy the fields
    }

    public ItemEntity getPreviousState(){
        return previousState;
    }
}