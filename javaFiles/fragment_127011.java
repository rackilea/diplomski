/// Convert this vector into a unit vector. Returns the length.
float32 b2Vec2::Normalize()
{
    float32 length = Length();
    if (length < b2_epsilon)
    {
        return 0.0f;
    }
    float32 invLength = 1.0f / length;
    x *= invLength;
    y *= invLength;

    return length;
}