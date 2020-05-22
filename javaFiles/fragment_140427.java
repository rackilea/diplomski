void normalize (vec2* vec)
{
    float mag = sqrt(vec->x * vec->x + vec->y * vec->y);
    // TODO: Deal with mag being 0
    vec->x /= mag;
    vec->y /= mag;
}