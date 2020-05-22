interface IA
{
    Iterable<? extends A> members();
}

interface IB extends IA
{
    @Override
    Iterable<? extends B> members();
}