@Override
public int compareTo(@NonNull HandComponent other) {

    // Check Type first
    int compareResult = mType.compareTo(other.mType);
    if(compareResult == 0)
    {
        // Check Card second
        compareResult = mCard.compareTo(other.mCard);
        if(compareResult == 0)
        {
            // Check Source last
            compareResult = mSource.compareTo(other.mSource);
        }
    }

    return compareResult;
}