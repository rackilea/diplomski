Scanner scan = new Scanner(System.in);

int dim = 5;
char[][] ground = new char[dim][dim];
Set<Integer> xSet = new HashSet<>();

System.out.print ("Please Enter an Integer");
int mineNum = scan.nextInt();

Random rand = new Random();
while (xSet.size() < mineNum) {
    int randomNum = rand.nextInt(dim*dim);
    xSet.add(randomNum);
}

// default everything to being Os
for (int r=0; r < dim; ++r) {
    for (int c=0; c < dim; ++c) {
        ground[r][c] = 'O';
    }
}

// then overwrite with Xs
for (int num : xSet) {
    int x = num % dim;
    int y = num / dim;
    ground[x][y] = 'X';
}

System.out.println(Arrays.deepToString(ground).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

[O, O, O, O, O]
[O, O, O, X, X]
[O, O, X, O, O]
[O, O, X, O, O]
[O, O, O, X, O]