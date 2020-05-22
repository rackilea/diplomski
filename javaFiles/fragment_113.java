String table[][] = new String[i][j];
table[i][j] "-----";
Scanner insertN = new Scanner(System.in);
int number1 = 1;
int number2 = 2;

int N = insertN.nextInt();
int total = N;

//build a temporary string containing as many '1's as indicated by n
String tmp = "";
for (int k = 0; k < N; k++) tmp = tmp + number1;

N = insertN.nextInt();
total = total + N;
for (int k = 0; k < N; k++) tmp = tmp + number2;

//replace the original string with the '1's and the substring of table[i][j]
//starting at position n and continuing to the end
table[i][j] = tmp + table[i][j].substring(total, table[i][j].length());