float signum = signum(sample);
sample = abs(sample);

if (sample < (1.0 / (1.0 + log(87.7)))) {
    sample = (float) (
        sample * ((1.0 + log(87.7)) / 87.7)
    );
} else {
    sample = (float) (
        exp((sample * (1.0 + log(87.7))) - 1.0) / 87.7
    );
}

sample = signum * sample;