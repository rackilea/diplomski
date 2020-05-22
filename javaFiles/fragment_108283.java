BufferedReader in = new BufferedReader(new FileReader("myfile.txt"));
boolean[][] mask = new boolean[640][480];
int i = -1;
int count = 0;
while((i = in.read()) !- -1) {
    int x = count % 640;
    int y = count / 640;
    mask[x][y] = (i == '1');
    count++;
}