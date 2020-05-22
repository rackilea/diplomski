@Override
public boolean equals(Object other)
{
    if (other == null || other.getClass() != this.getClass())
    {
        return false;
    }
    Permutation otherPermutation = (Permutation) other;

    // List.equals should do the right thing here
    return elements.equals(otherPermutation.elements);
}