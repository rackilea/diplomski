@Entity
@Table(name='Foo')
class Foo {

    @Transient
    private Foo previousState;

    @PostLoad
    private void setPreviousState(){
        previousState = new Foo();
        //copy the fields
    }

    public Foo getPreviousState(){
        return previousState;
    }

}