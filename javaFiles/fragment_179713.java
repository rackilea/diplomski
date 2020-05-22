public class MathTime {
    static float[][] float1 = new float[8][16];
    static float[][] float2 = new float[8][16];

    public static void main(String[] args) {
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 16; k++) {
                float1[j][k] = (float) (j + k);
                float2[j][k] = (float) (j + k);
            }
        }
        new Test().run();
    }

    private static class Test {
        int int3;

        public void run() {
            for (String test : new String[] { "warmup", "real" }) {

                long t0 = System.nanoTime();

                for (int count = 0; count < 1e7; count++) {
                    int i = count % 8;
                    int3 += Math.round(float1[i][0] + float2[i][0]);
                    int3 += Math.round(float1[i][1] + float2[i][1]);
                    int3 += Math.round(float1[i][2] + float2[i][2]);
                    int3 += Math.round(float1[i][3] + float2[i][3]);
                    int3 += Math.round(float1[i][4] + float2[i][4]);
                    int3 += Math.round(float1[i][5] + float2[i][5]);
                    int3 += Math.round(float1[i][6] + float2[i][6]);
                    int3 += Math.round(float1[i][7] + float2[i][7]);
                    int3 += Math.round(float1[i][8] + float2[i][8]);
                    int3 += Math.round(float1[i][9] + float2[i][9]);
                    int3 += Math.round(float1[i][10] + float2[i][10]);
                    int3 += Math.round(float1[i][11] + float2[i][11]);
                    int3 += Math.round(float1[i][12] + float2[i][12]);
                    int3 += Math.round(float1[i][13] + float2[i][13]);
                    int3 += Math.round(float1[i][14] + float2[i][14]);
                    int3 += Math.round(float1[i][15] + float2[i][15]);

                    int3 += Math.round(float1[i][0] * float2[i][0]);
                    int3 += Math.round(float1[i][1] * float2[i][1]);
                    int3 += Math.round(float1[i][2] * float2[i][2]);
                    int3 += Math.round(float1[i][3] * float2[i][3]);
                    int3 += Math.round(float1[i][4] * float2[i][4]);
                    int3 += Math.round(float1[i][5] * float2[i][5]);
                    int3 += Math.round(float1[i][6] * float2[i][6]);
                    int3 += Math.round(float1[i][7] * float2[i][7]);
                    int3 += Math.round(float1[i][8] * float2[i][8]);
                    int3 += Math.round(float1[i][9] * float2[i][9]);
                    int3 += Math.round(float1[i][10] * float2[i][10]);
                    int3 += Math.round(float1[i][11] * float2[i][11]);
                    int3 += Math.round(float1[i][12] * float2[i][12]);
                    int3 += Math.round(float1[i][13] * float2[i][13]);
                    int3 += Math.round(float1[i][14] * float2[i][14]);
                    int3 += Math.round(float1[i][15] * float2[i][15]);

                    int3 += Math.round(float1[i][0] / float2[i][0]);
                    int3 += Math.round(float1[i][1] / float2[i][1]);
                    int3 += Math.round(float1[i][2] / float2[i][2]);
                    int3 += Math.round(float1[i][3] / float2[i][3]);
                    int3 += Math.round(float1[i][4] / float2[i][4]);
                    int3 += Math.round(float1[i][5] / float2[i][5]);
                    int3 += Math.round(float1[i][6] / float2[i][6]);
                    int3 += Math.round(float1[i][7] / float2[i][7]);
                    int3 += Math.round(float1[i][8] / float2[i][8]);
                    int3 += Math.round(float1[i][9] / float2[i][9]);
                    int3 += Math.round(float1[i][10] / float2[i][10]);
                    int3 += Math.round(float1[i][11] / float2[i][11]);
                    int3 += Math.round(float1[i][12] / float2[i][12]);
                    int3 += Math.round(float1[i][13] / float2[i][13]);
                    int3 += Math.round(float1[i][14] / float2[i][14]);
                    int3 += Math.round(float1[i][15] / float2[i][15]);

                }
                long t1 = System.nanoTime();
                System.out.println(int3);
                System.out.println(String.format("%s, Math.round(float), %s, %.1f ms", System.getProperty("java.version"), test, (t1 - t0) / 1e6));
            }
        }
    }
}