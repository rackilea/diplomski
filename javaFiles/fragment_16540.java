double max = 1.0 / (1.0 - exp(-gain_pre));
for (int i = 0; i < duration; i++)
{
    double sample = samples[i] * gain_pre;
    double z = (sample < 0.0) ? (-1.0 + exp(sample)) :
                                (1.0 - exp(-sample));   
    samples[i] = z * max * gain_post;
}