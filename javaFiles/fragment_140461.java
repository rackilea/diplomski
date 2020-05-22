public static boolean linearSearchOne(int[] iTempArray, int SIZE, int ENTRY) {
    for (int i = 0; i < SIZE; i++) {
        if (iTempArray[i] == ENTRY) {
            return true;
        }
    }
    return false
}

public static int linearSearchTwo(int[] iTempArray, int SIZE, int ENTRY) {

    int HowManyExist;
    for (int i = 0; i < SIZE; i++) {
        if (iTempArray[i] == ENTRY) {
            HowManyExist ++;
        }
    }
    return HowManyExist;
}