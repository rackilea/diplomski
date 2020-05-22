// Idea: there are 3 cases:
// 1. tokensToSkip is 0: process as normal (check for palindromeness)
// 2. tokensToSkip is 1: decrement it to 0, but process as normal
// 3. tokensToSkip is 2, 3, 4...: decrement it and skip (continue the while)
// Note that tokensToSkip will never be negative.

// Will skip tokensToSkip - 1 tokens
int tokensToSkip = 0;
while(scanInput.hasNext()) {
    String token = scanInput.next();
    // instead of the next two lines we could just have:
    //     if (--tokensToSkip > 0) continue;
    // only once, notice the -- operator in front.
    //
    // This would almost always work, but if tokensToSkip = Integer.MIN_VALUE
    // decrementing it will cause negative overflow and thus tokensToSkip will
    // become Integer.MAX_VALUE! To prevent this we have a check.
    if (tokensToSkip > 0) tokensToSkip--;

    // here tokensToSkip is already decremented, so this check is different
    // from the one above. For example is tokensToSkip == 1 before the line
    // above, now it is tokensToSkip == 0 and this second check fails.
    if (tokensToSkip > 0) continue;
    if (isPalindrome(token)) {
        tokensToSkip = token.length();
    }
    // ... other stuff ...
}