Iterator<MyObject> namesIterator = withNames.iterator();
    Iterator<MyObject> noNamesIterator = noNames.iterator();

    while (newList.size() < userDefinedSize) {
        if (namesIterator.hasNext()) {
            newList.add(namesIterator.next());
        }

        if (noNamesIterator.hasNext() && newList.size() < userDefinedSize) {
            newList.add(noNamesIterator.next());
        }
    }