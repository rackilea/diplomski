boolean filtersResult = false;
for (IFilter filter : filters) {
    filterResult = filter.process(mypojos[i])

    if (filterResult)
        break;
}