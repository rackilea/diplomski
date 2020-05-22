String lastHit = stream.findWithinHorizon(tagRE, 0);  // always use '0'
while (lastHit != null)
{
    MatchResult lastMatch = stream.match();

    // ...

    lastHit = stream.findWithinHorizon(tagRE, 0);
}