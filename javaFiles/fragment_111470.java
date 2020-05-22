import ij.process.FloatProcessor;

public class SimpleTest {

    public static float[] func(float []bm, int nx, int ny) {
        FloatProcessor p = new FloatProcessor(nx,ny);
        p.setPixels(bm);
        float[] kernel = new float[{0.111f,0.111f,0.111f,0.111f,
                                    0.111f,0.111f,0.111f,0.111f,0.111f};
        p.convolve(kernel, 3, 3);
        return (float[]) p.getPixels();
    }
}