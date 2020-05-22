sample = (float) (
    signum(sample)
        *
    (1.0 / 255.0)
        *
    (pow(256.0, abs(sample)) - 1.0)
);