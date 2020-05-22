List findPossibleInsertions(String currentString)
{
    List list = {};
    for(int pos = 0; pos < currentString.length + 1; pos++)
    {
        for(char c = 'a'; c <= 'z'; c++)
        {
            String insertedString = insert c into currentString before pos;
            if(stringIsImpossible(insertedString))
                continue;   // high level test whether the string could be turned into a valid word

            int64 stringMask = computeStringMask(insertedString);

            // the string is not impossible according to the test, but we need to verify that it is actually possible:
            for(String s in Dictionary)
            {
                // check if the string could be turned into s via insertions using a simple mask check to potentially exclude it (but not 100% confirm it):
                if((s.mask & stringMask) != stringMask)
                    continue;   // it's not possible to turn insertedString into s via insertions

                if(s.length < insertedString.length)
                    continue; // can't insert chars to make a shorter string

                // confirm that is it possible:
                if(canMakeStringViaInsertions(insertedString, s)
                {
                    list.add(insertedString); // this is a valid insertion, add to the list
                    break;
                }
            }
        }
    }
}