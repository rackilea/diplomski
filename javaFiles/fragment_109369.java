public DataImporter doYourCategoryStuff()
{
    List<String> categories = getCategories();
    ... blah including the for loop.

    return theDataImporter;
}


public void doAllTheStuffs()
{
    final DataImporter theDataImporter;

    theDataImporter.doYourCategorStuff();

    populateImportedData(theDataImporter.importData());
}