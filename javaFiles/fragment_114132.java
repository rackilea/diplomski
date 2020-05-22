// no hashCode(), but...

@Override
// simplified
public boolean equals(@Nullable final Object obj)
{
    // instanceOf works with null, so this works
    if (!(obj instanceOf Bucket))
        return false;
    return ((Bucket) obj).number == number;
}