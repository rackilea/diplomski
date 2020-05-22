public static void main(String[] args) {

    Scanner reader = new Scanner(System.in);
    List<Integer> data = new ArrayList<Integer>();
    System.out.println("input count of numbers to inputed:\t");
    int limit = 0;
    if (reader.hasNext("\\d+")) {
        reader.nextInt();
    } else {
        System.out.println("wrong input");
        return;
    }
    System.out.println("please input data:\t");

    for (int i = 0; i < limit; i++) {

        if (reader.hasNext("\\d+")) {
            data.add(reader.nextInt());
        } else {
            System.out.println("Your input is malformed. Try again");
            break;
        }
    }

    reader.close();

}