@Override
public boolean equals(Object o)
{
    if (o instanceof Pair) {
       Pair<?, ?> pair = (Pair<?, ?>) o;
       return _1.equals(pair._1) && _2.equals(pair._2);
    }
    return false;
}