public class MyList<E> extends ArrayList<E>
{

    @Override
    public boolean add(E e)
    {

        if (!checkInput())
        {
            throw new UnexpectedInputException();
        }
        return super.add(e);
    }

    private boolean checkInput()
    {
        // Really check the input!
        return false;
    }

}