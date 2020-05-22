String[] arr = new String[5];

arr[0] = question;
arr[1] = a;
arr[2] = b;
arr[3] = c;
arr[4] = correct;

System.out.println(arr[0] + "\n");
System.out.println("Answer a: " + arr[1]);
System.out.println("Answer b: " + arr[2]);
System.out.println("Answer c: " + arr[3] + "\n");

int i = 0;
while (i != 1) {
    Scanner userin = new Scanner(System.in);

    System.out.println("Type a,b,c for correct answer.\n");

    String selected = userin.next();

    if (selected.equals(correct)) {
        i = 1;
        System.out.println("\nCorrect!");
    }else {
        System.out.println("Try again");
    }
}