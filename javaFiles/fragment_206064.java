// Only the alternation is needed, no need for the capture
private static final Pattern PATTERN
    = Pattern.compile("012|123|234|345|456|567|678|789|890");

// ...

if (PATTERN.matcher(input).find())
    // fail: illegal sequence found