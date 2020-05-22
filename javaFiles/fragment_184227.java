public String[] getValues(int start, int end) {
        List<String> valueList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            valueList.add(getValue(i));
        }
        String[] valueArr = new String[valueList.size()];
        valueArr = valueList.toArray(valueArr);
        return valueArr;
    }