public float getHeightApprox(float x, float z)
{
    return ( (getHeightAt(x,z)
            + getHeightAt(x + 1, z)
            + getHeightAt(x - 1, z)
            + getHeightAt(x, z + 1)
            + getHeightAt(x, z - 1)) / 5);
}