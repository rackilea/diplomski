int highest = 0;
int lowest = 100;
while (scores > 0 && in.hasNextInt()) {
 int grade = in.nextInt();

 if (grade >= 90) {
    A++;
 } else if (grade >= 80) {
    B++;
 } else if (grade >= 70) {
    C++;
 } else if (grade >= 60) {
    D++;
 } else {
    F++;
 }

 if (grade > highest) {
    highest = grade;
 }
 if (grade < lowest) {
    lowest = grade;
 }
 scores--;
 scoreTotals = (scoreTotals + grade);
}