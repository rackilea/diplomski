//Use a try with resources so that the scanner is closed on completion
 int maleCount = 0;
 int femaleCount = 0;
 try (Scanner scanner = new Scanner(f)) {

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        //TODO Check line is not empty whitespace... A good way of doing this is to use StringUtils.isBlank() in Apache Commons
        if (line.length() == 0) {
              //What to do?
        }
        String[] parts = line.split(" ");
        if (parts.length != 2) {
             //What do you want to do with an invalid line? Skip it? End program?
        } else {
            //wrap in a try catch - what if parts[X] isn't a number?
            //Or check the string contains only digits before parsing using StringUtils.isNumeric() which is part of Apache Commons 
            femaleCount += Integer.parseInt(parts[0]);
            maleCount += Integer.parseInt(parts[1]);
        }
    }
}
//Use the counts