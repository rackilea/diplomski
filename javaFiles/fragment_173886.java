boolean isValidInput = true;
do
{
    String answer1 = scan.next();
    switch(answer1.toUpperCase()) {
        case "A": 
            System.out.println("Wrong, correct answer is B");
            isValidInput = true;
            break;
        case "B": 
            score++;
            System.out.println("Correct!"); 
            isValidInput = true;
            break;
        case "C":
            System.out.println("Wrong, correct answer is B");
            isValidInput = true;
            break;
        default:
            System.out.println("INVALID! Must be letters only, Try again");
            isValidInput = false;
    }
} 
while (!isValidInput);