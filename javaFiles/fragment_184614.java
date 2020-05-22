class AbstractToy {
    protected abstract String getName();
    protected abstract String getSize();
    public String getDescription() {
        return "This is a really "+getSize()+" "+getName();
    }
}
class ToyBear extends AbstractToy {
    protected override String getName() { return "bear"; }
    protected override String getSize() { return "big"; }
}
class ToyPenguin extends AbstractToy {
    protected override String getName() { return "penguin"; }
    protected override String getSize() { return "tiny"; }
}