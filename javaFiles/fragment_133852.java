public static int countSTR(char c1[], int c1Length, char c2[], int c2Length) {
    if (c1 == null || c2 == null || c1Length < 1 || c2Length < 1 || c1Length > c1.length || c2Length > c2.length)
        return 0;

    int count = 0;

    for (int i = 0; i <= c1Length - c2Length; i++)
        for (int j = 0; j < c2Length; j++)
            if (c1[i + j] == c2[j]) {
                if (j == c2Length - 1)
                    count++;
            } else
                break;
    return count;
}