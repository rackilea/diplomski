int[] arr = { 1, 2, 0, 1, -1, 0, 2 };
loop:
for (int num : arr) {
    switch (num) {
    case 1:
        System.out.print("One ");
        break;
    case 2:
        System.out.print("Two ");
        break;
    case 0:
        System.out.print("Zero ");
        continue loop;
    default:
        break loop;
    }
    System.out.print("(" + num + ") ");
}
// prints "One (1) Two (2) Zero One (1) "