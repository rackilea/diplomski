Scanner input = new Scanner(System.in);

int m = input.nextInt();
int n= input.nextInt();

int[] lines = new int[m];
for (int i = 0; i < m; i++) {
    lines[i] = input.nextInt();
}

String[] words = new String[n];
for (int i = 0; i < n; i++) {
    words[i] = input.next();
}