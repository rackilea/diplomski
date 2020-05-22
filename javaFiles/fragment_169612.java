public class Goal<B extends X<Goal<B>, B>> implements Y<Goal<B>, B> {

    private final B minix;

    public Goal(B minix) {
        this.minix = minix;
    } 

    @Override
    public B getX() {
        return minix;
    }

    @Override
    public void doSomething() {
        minix.getO();       
    }

}