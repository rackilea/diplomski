String content = "436f 6e74 656e 742d 4c65 6e67 7468 3a20"
        + "3138 3830 0d0a 0d0a ffd8 ffe0 0010 4a46"
        + "4946 0001 0101 0060 0060 0000 ffdb 0043"
        + "0010 0b0c 0e0c 0a10 0e0d 0e12 1110 1318"
        + "281a 1816 1618 3123 251d 283a 333d 3c39"
        + "3338 3740 485c 4e40 4457 4537 3850 6d51";

StringBuilder sb = new StringBuilder(content.replaceAll(" ", ""));
sb.delete(0, 48); // remove "Content-Length: 1880"
try (FileOutputStream fos = new FileOutputStream("content.jpg")) {
    while (sb.length() > 2) {
        fos.write(Integer.parseInt(sb.substring(0, 2), 16));
        sb.delete(0, 2);
    }
}