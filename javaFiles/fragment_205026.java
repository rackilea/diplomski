long temp;
if (isBigEndian) {
    temp = (
          ((bytes[i    ] & 0xffL) << 16)
        | ((bytes[i + 1] & 0xffL) <<  8)
        |  (bytes[i + 2] & 0xffL)
    );
} else {
    temp = (
           (bytes[i    ] & 0xffL)
        | ((bytes[i + 1] & 0xffL) <<  8)
        | ((bytes[i + 2] & 0xffL) << 16)
    );
}