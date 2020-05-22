@Override
protected ConstantOrderingCard clone() throws CloneNotSupportedException
{
    ConstantOrderingCard copy = (ConstantOrderingCard) super.clone();

    copy.rankOrdering = new HashMap<>(copy.rankOrdering);
    copy.suitOrdering = new HashMap<>(copy.suitOrdering);

    return copy;
}