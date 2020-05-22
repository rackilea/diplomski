/**
 * Fills the suggestionList with the given luceneResult.
 *
 * @param suggestionList                 The list to fill.
 * @param luceneResult                   The previously computed luceneResult.
 */
private static void fillLookupSuggestionList(final List<SelectItem> suggestionList,
    LuceneResult luceneResult)
{
    suggestionList.clear();

    String searchQuery = luceneResult.getLuceneResultConfig().getSearchQuery(); 
    if (luceneResult.getResultSize() <= 0)
    {
        suggestionList.add(new SelectItem(null, BundleHelper.i18n(LuceneLookupController.BUNDLE,
            LuceneLookupController.NO_ITEM_FOUND)));
    }
    else
    {
        List<LuceneResultEntry> results = luceneResult.getResult();
        for (LuceneResultEntry entry : results)
        {
            suggestionList.add(new SelectItem(entry.getMetaInfo(),
                entry.getInfo().getDescription()));
        }
    }
}