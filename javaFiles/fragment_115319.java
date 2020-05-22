Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    int flag = 0;
    int arr[][] = new int[t][2];
    for (int i = 0; i < t; i++) {
        for (int j = 0; j < 2; j++) {
            arr[i][j] = s.nextInt();
        }
    }
    for (int a = 0; a < t; a++) {
        for (int b = arr[a][0]; b <= arr[a][1]; b++) {
            if (b < 2) {
                b = 2;
            }
            for (int c = 2; c*c <= b; c++) {
                if (b % c == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(b);
            } else {
                flag = 0;
            }
        }
    }