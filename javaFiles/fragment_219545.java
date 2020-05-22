protected int matchMethod(MethodBinding method, boolean skipImpossibleArg) {
    [...]
    // verify each parameter
    for (int i = 0; i < parameterCount; i++) {
        TypeBinding argType = method.parameters[i];
        int newLevel = IMPOSSIBLE_MATCH;
        if (argType.isMemberType()) {
            // only compare source name for member type (bug 41018)
            newLevel = CharOperation.match(this.pattern.parameterSimpleNames[i], argType.sourceName(), this.isCaseSensitive)
                ? ACCURATE_MATCH
                : IMPOSSIBLE_MATCH;
        } else {
            // TODO (frederic) use this call to refine accuracy on parameter types
            // newLevel = resolveLevelForType(this.pattern.parameterSimpleNames[i], this.pattern.parameterQualifications[i], this.pattern.parametersTypeArguments[i], 0, argType);
            newLevel = resolveLevelForType(this.pattern.parameterSimpleNames[i], this.pattern.parameterQualifications[i], argType);
            [...]
        }
    }
    [...]
}