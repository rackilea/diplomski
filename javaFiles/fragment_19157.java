List<DataClass> result = new ArrayList<>();

for (DataClass item : dataList) {
    if (!result.contains(item)) {
        result.add(item);
    }
}
return result;