interface IA<X extends A> extends Iterable<X>
{
    @Override Iterator<X> iterator();
}
interface IB extends IA<B>
{
    @Override Iterator<B> iterator();
}