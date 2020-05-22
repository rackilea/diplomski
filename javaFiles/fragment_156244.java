abstract class MyAbstract2<T extends String> extends MyAbstract<T>
{
    T upperVal_;

    MyAbstract(T val)
    {
        super(val);
        upperVal_ = val.toUpperCase();
    }

    @Override
    T getVal()
    { 
        return upperVal_; 
    }
}