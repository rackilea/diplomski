bool IsSequence(string input)
{
    // we need at least two characters
    // for a sequence
    if (input.Length < 2)
        return false;

    // get the "delta" between first two
    // characters
    int difference = input[1] - input[0];

    // allowed differences are:
    //   -1: descending sequence
    //    0: repetitive digits
    //    1: ascending sequence
    if (difference < -1 || difference > 1)
        return false;

    // check if all characters are equally
    // distributed
    for (int i = 2; i < input.Length; i++)
        if (input[i] - input[i - 1] != difference)
            return false;

    // this is a sequence
    return true;
}