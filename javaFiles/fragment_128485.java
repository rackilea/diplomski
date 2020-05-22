public enum ModelMapper
{
Ford("Ford", "frd"),
Renault("Renault", "rnlt");

private final String carAValue;
private final String carBValue;

ModelMapper(String carA_value, String carB_value) 
{
    carAValue = carA_value; 
    carBValue = carB_value;       
}

public static String getCarAValue(String carB_value)
{
    for (ModelMapper m: ModelMapper.values()) {
        if (m.carBValue.equals(carB_value)) {
            return m.carAValue;
        }  
    }
    throw new IllegalArgumentException(carB_value);
}
}