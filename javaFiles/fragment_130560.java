public interface Opener {
    // or something similar
    double fractionToOpen();

    Opener FULL_OPENER = () -> 1.0;
    Opener HALF_OPENER = () -> 0.5;
}