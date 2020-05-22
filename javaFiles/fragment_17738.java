public class FloatArray {
    public static void main(String[] args) {
        float[] data = new float[10];
        data[5] = Float.NaN;
        for (float f : data){
            if (Float.isNaN(f)){
                System.out.println("No Valve");
            } else {
                System.out.println(f);
            }
        }
    }
}