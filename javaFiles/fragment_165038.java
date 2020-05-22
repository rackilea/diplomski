/**
 * computes single bone influence
 *
 * @param m current bone transformation Matrix
 * @param t position vector
 * @param f flag: 1 position, 0 direction
 * @return Vector3 single bone influence
 */
private static Vector3 getSingleBoneInfluence(Matrix4 m, Vector3 t, float f) {
    float[] pI = new float[4];
    pI[0] = m.values[0]  * t.x + m.values[4]  * t.y + m.values[8]  * t.z + m.values[12]  * f;
    pI[1] = m.values[1]  * t.x + m.values[5]  * t.y + m.values[9]  * t.z + m.values[13]  * f;
    pI[2] = m.values[2]  * t.x + m.values[6]  * t.y + m.values[10] * t.z + m.values[14]  * f;

    return Vector3.createNew(pI[0], pI[1], pI[2]);
}