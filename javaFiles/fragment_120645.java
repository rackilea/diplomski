int oneTwo(int p) {
    return p >> 8;
}
int oneThree(int p) {
    return ((p & 0x00F0) >> 4) | ((p & 0xF000) >> 8);
}
int oneFour(int p) {
    return (p & 0x000F) | ((p & 0xF000) >> 8);
}
int twoThree(int p) {
    return (p & 0x0FF0) >> 4;
}
int twoFour(int p) {
    return (p & 0x000F) | ((p & 0x0F00) >> 4);
}
int threeFour(int p) {
    return p & 0x00FF;
}