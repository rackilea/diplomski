private static final String DT_STEPS = "com.google.step_count.delta";
private static final DataTypeField FIELD_STEPS = new 
        DataTypeField().setName("steps").setFormat(FORMAT_INTEGER);
private static final List<DataTypeField> STEPS_FIELDS = Arrays.asList(
                                                        FIELD_STEPS);
public static final DataType DATA_TYPE_STEPS = 
                            new DataType()
                                .setName(DT_STEPS)
                                .setField(STEPS_FIELDS);