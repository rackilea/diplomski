public function allVariablesContains(List<Integer[]> allVariables, int intToSearchFor)
{
    if (allVariables == null)
        return false;
    for (int i = 0; i < allVariables.Length; i++)
    {
        if (allVariables[i] == null)
            continue;
        if (Arrays.asList(allVariables).contains(intToSearchFor))
            return true;
    }
    return false;
}