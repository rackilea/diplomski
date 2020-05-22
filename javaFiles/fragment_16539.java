for (int i = 0; i < duration; i++)
{
    double sample = samples[i] * gain_pre;
    if (sample > clip)
        sample = clip;
    else
    if (sample < -clip)
        sample = -clip;
    samples[i] = sample * gain_post;
}