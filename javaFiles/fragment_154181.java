public static void main(String[] args) throws FileNotFoundException {

Scanner scanner = new Scanner(new File("random5k.txt"));
ListNode insertion = new ListNode(scanner.nextInt());
ListNode intNodes = insertion;
while(scanner.hasNextInt()){
    ListNode nextNode = new ListNode(scanner.nextInt());
    insertion.next = nextNode;
    insertion = nextNode;
}
intNodes = insertionSortList(intNodes);
}