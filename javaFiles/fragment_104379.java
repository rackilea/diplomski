Scanner scanner = new Scanner(System.in);
    double weight = 0;
    double height = 0;
    System.out.println("Please enter how much you weigh in KG.");
    while (scanner.hasNext()) {
        if (scanner.hasNextDouble()) {
            // correct value
            weight = scanner.nextDouble();
        } else {
            System.out.println("Please enter correct value.");
            scanner.next();
            continue;
        }
        System.out.println("Please enter how tall you are in meters.");
        if (scanner.hasNextDouble()) {
            // correct value
            height = scanner.nextDouble();
        } else {
            System.out.println("Please enter correct value.");
            scanner.next();
            continue;
        }
        break;
    }
    double bmi = weight / Math.pow(height, 2);
    System.out.println("Your BMI :"+bmi);
    //Rest of the code remains the same