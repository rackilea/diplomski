Set<DataImporter> updateSet = new HashSet<>();

for (category for loop)
{
    final DataImporter child = importer.getChild(category);
    if (child != null)
    {
        updateSet.add(child);
        updateSet.add(importer);
    }
}

for (final DataImporter current : updateSet)
{
    current.importData();
}