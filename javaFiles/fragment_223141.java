static final Map<String, Runnable> MAPPING;
static {
    Map<String, Runnable> temp = new HashMap<>();
    temp.put(HwErrorsEtlConstants.MR_RAW_GRADIENT_ERRORS, this::method1);
    temp.put(HwErrorsEtlConstants.MR_RAW_PFEI_ERRORS, this::method2);
    temp.put(HwErrorsEtlConstants.MR_RAW_RFAMP_ERRORS, this::method3);
    MAPPING = Collections.unmodifiableMap(temp);
}