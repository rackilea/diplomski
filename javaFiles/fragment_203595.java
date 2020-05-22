class InsertHandler implements Runnable {
    final float[] accelerometerMatrix;
    final float[] accelerometerWorldMatrix;
    final float[] gyroscopeMatrix;
    final float[] gravityMatrix;
    final float[] magneticMatrix;
    final float[] rotationMatrix;

    public InsertHandler(float[] accelerometerMatrix, float[] accelerometerWorldMatrix,
            float[] gyroscopeMatrix, float[] gravityMatrix,
            float[] magneticMatrix, float[] rotationMatrix) {
        this.accelerometerMatrix = accelerometerMatrix;
        this.accelerometerWorldMatrix = accelerometerWorldMatrix;
        this.gyroscopeMatrix = gyroscopeMatrix;
        this.gravityMatrix = gravityMatrix;
        this.magneticMatrix = magneticMatrix;
        this.rotationMatrix = rotationMatrix;
    }

    public void run() {
        // use class field arrays values and insert into db
    }
}