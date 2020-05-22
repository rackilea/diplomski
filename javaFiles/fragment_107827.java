private static Data[] convertMap2Data(HashMap<String, HashMap> map) {
    Data[] data = new Data[map.size()];
    int index = 0;
    for (Map.Entry<String, HashMap> entry : map.entrySet()) {
        data[index++] = new Data(entry.getKey(), convertMap2Data(entry.getValue()));
    }
    return data;
}