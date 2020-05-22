Scanner scanner=new Scanner(System.in);
    int row = scanner.nextInt();
    int col = scanner.nextInt();
    ArrayList<Integer> list=null;
    for (int j = 0; j < row; j++) {
        for (int i = 0; i < col; i++) {
            list = new ArrayList<>();
            list.add(scanner.nextInt());
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(list);
    }