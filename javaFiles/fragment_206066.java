private final List<PasswordChecker> checkers = ...;

// then

for (final PasswordChecker checker: checkers)
    if (!checker.isValid(passwd))
        return false;
return true;