public final static float[] perlinThresholds = new float[]{}; //Initialize it with the generated thresholds.

public static float getThreshold(float percent) {
    return perlinThresholds[(int)(percent * 1000)];
}

public static float getThreshold(int promill) {
    return perlinThresholds[promill];
}

X