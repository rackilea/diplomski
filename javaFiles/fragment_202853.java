if(!bundleInformation.isEmpty()) {
    oldBundleList = bundleList;
    bundleList = bundleInformation;
}

if(!oldBundleList.isEmpty()) {
    final Map<String, MapDifference.ValueDifference<String>> entriesDiffering =
                  Maps.difference(oldBundleList, bundleList).entriesDiffering();

    if (!entriesDiffering.isEmpty()) {          
        for (String key : entriesDiffering.keySet()) {
            newBundleList.put(key, bundleList.get(key));
            System.out.println("{" + key + "=" + bundleList.get(key) + "}");
        } 
        process(newBundleList);
    }
} else {
    process(bundleList);
}