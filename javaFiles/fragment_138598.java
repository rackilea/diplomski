int alphaValue = alpha & 0xff;
for (...) {
    for (...) {
        // Inside the loop:
        color |= (alphaValue << 24);
    }
}