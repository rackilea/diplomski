public final BaseAdapter[] adapters() {
    BaseAdapter[] adapters = createAdapters();
    if (adapters.length != 3)
        throw new Exception("Error: Please return 3 adapters.");
    return adapters;
}