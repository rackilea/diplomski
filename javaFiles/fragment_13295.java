total = total.toLowerCase();

String grades[] = total.split(" ");
for (String grade : grades){
    if (grade.equals("a")) {
        input = 4.0;
    } else if (grade.equals("b")) {
        input = 3.0;
    } else if (grade.equals("c")) {
        input = 2.0;
    } else if (grade.equals("d")) {
        input = 1.0;
    } else if (grade.equals("f")) {
         fail = true;
         input = 0.0; //needed as if it fails it will still add previous value onto total
    }
    gpa += input;
    classes++;
}