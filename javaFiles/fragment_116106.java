static int keywordsChecker(String shortEssay, String keywords) {
    int count = 0;
    String[] ary = keywords.split(",");

    for (int i = 0; i < ary.length; i++) {            

        if (shortEssay.contains(ary[i])) {
            count++;
        }
    }
    return count;
}

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter keywords: ");
    String keyword = input.nextLine();
    System.out.println("Enter essay: ");
    String essay = input.nextLine();
    System.out.println(keywordsChecker(essay, keyword));

}