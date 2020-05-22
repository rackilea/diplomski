import java.nio.FloatBuffer;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

@Platform(include = "Dot.h", compiler = "fastfpu")
public class Dot {
    static { Loader.load(); }

    static float[] a = new float[50], b = new float[50];
    static float dot() {
        float sum = 0;
        for (int i = 0; i < 50; i++) {
            sum += a[i]*b[i];
        }
        return sum;
    }
    static native @MemberGetter FloatPointer ac();
    static native @MemberGetter FloatPointer bc();
    static native @NoException float dotc();

    public static void main(String[] args) {
        FloatBuffer ab = ac().capacity(50).asBuffer();
        FloatBuffer bb = bc().capacity(50).asBuffer();

        for (int i = 0; i < 10000000; i++) {
            a[i%50] = b[i%50] = dot();
            float sum = dotc();
            ab.put(i%50, sum);
            bb.put(i%50, sum);
        }
        long t1 = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            a[i%50] = b[i%50] = dot();
        }
        long t2 = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            float sum = dotc();
            ab.put(i%50, sum);
            bb.put(i%50, sum);
        }
        long t3 = System.nanoTime();
        System.out.println("dot(): " + (t2 - t1)/10000000 + " ns");
        System.out.println("dotc(): "  + (t3 - t2)/10000000 + " ns");
    }
}