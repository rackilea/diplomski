List<String> allAgenciesList = new ArrayList<String>();
// [...]
for(RenameRuleEntry rEntry : vRenameRuleEntryList) {
    List<String> workset = new ArrayList<String>(allAgenciesList);
    // [...]
    // Work with workset instead of allAgenciesList from now on
}