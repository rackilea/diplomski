@Column(FIELDS_FOR_SAMPLE_VIEW_BOX)
private String fieldsForSampleViewBox;

public void setFieldsForSampleViewBox(Integer[] array) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
        if (array[i] != null) {
            b.append(array[i]);
        }
        if (i < array.length - 1) {
            b.append(',');
        }
    }
    fieldsForSampleViewBox = b.toString();
}

public Integer getFieldsForSampleViewBox() {
    if (fieldsForSampleViewBox == null || fieldsForSampleViewBox.length() == 0) {
        return new Integer[0];
    }
    String[] strings = fieldsForSampleViewBox.split(",");
    Integer[] result = new Integer(strings.length());
    for (int i = 0; i < strings.length(); i++) {
        if (!strings[i].equals("") {
            result[i] = Integer.valueOf(strings[i]);
        }
    }
    return result;
}