public static void main(String[] ar) throws IOException {
    n=7;
    a = new int[][]{ {0,0,1,0,0,1,0},
                {1,0,1,1,0,0,0},
                {0,0,0,0,1,0,1},
                {1,0,1,0,0,0,0},
                {1,0,1,1,0,1,0},
                {1,0,0,0,0,1,0},
                {1,1,1,1,0,0,0}};

    search(0,0);
    System.out.println(path);
}