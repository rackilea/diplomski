interface Interface2<T>

    public <V> V readObject(ITransform<T,V> converter)


class Class3 implements Interface2<CharBuffer>

    public <V> V readObject(ITransform<CharBuffer,V> converter)
    {
        return class1.readObject(converter, decoder);
    }