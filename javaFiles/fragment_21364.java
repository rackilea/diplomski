struct fp_img {
    int width;
    int height;
    size_t length;
    uint16_t flags;
    struct fp_minutiae *minutiae;
    unsigned char *binarized;
    unsigned char data[0];
};