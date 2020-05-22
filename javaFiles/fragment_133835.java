for (int i = 0; i < mogrades.length; i++) {

            System.out.println("Enter grade " + (i+1) + ": ");

            mogrades[i] = NumberReader.readPositiveDouble(input, 
                        "Enter grade: ", "Invalid data entered");