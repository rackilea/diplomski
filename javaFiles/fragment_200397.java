public abstract class MeasurementType {
    protected  String name;

    private static final Map<String, Class<? extends MeasurementType>> typeMap = new HashMap<>();
    static{
        typeMap.put("accelaration", Acceleration.class);
        typeMap.put("density", Density.class);
       //put here if you have others
    }

    public static MeasurementType getMeasurement(String keyStr) throws RuntimeException {
        if (typeMap.containsKey(keyStr)) {
            try {
                return typeMap.get(keyStr).newInstance();
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("creation failed.");
            }
        }
            //this could be a speical exception type
        throw new RuntimeException("creation failed: unknown type"); 
    }

}