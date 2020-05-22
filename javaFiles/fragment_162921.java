public static void main(String[] args) {
        int uint8 = 0xff;
        int uint16 = 0xffff;
        long uint32 = 0xffffffff;

        int one = 0x0001;
        int ten = 0x000A;
        int twoComplementOfTen = 0xFFF6;
        int computedTwoComplementOfTen = ~ten + one;
        int revertTwoComplementOfTen = ~twoComplementOfTen + one;

        System.out.printf("One = 0x%04X \n", one);
        System.out.printf("ten = 0x%04X \n", ten);
        System.out.printf("~ten + one = 0x%04X \n", twoComplementOfTen);
        System.out.printf("Computed ~ten + one = 0x%04X \n", computedTwoComplementOfTen);
        System.out.printf("~twoComplementOfTen + one = 0x%04X \n", revertTwoComplementOfTen);

        System.out.printf("Computed ~ten + one with uint16 mask = 0x%04X \n", uint16 & computedTwoComplementOfTen);
        System.out.printf("~twoComplementOfTen + one with uint16 mask  = 0x%04X \n", uint16 & revertTwoComplementOfTen);
    }