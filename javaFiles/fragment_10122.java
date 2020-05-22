byte ins = (byte) 0x80;

switch (ins) {
    case (byte) 0x80:
        System.out.println("switch matched");
        break;
    default:
        System.out.println("switch missed");
}

if (ins == (byte) 0x80) {
    System.out.println("if matched");
} else {
    System.out.println("if missed");
}