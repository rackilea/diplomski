int k = 0;

            if (counter < 20) {

                while (answer != 0) {  // what have i done here with that 0 answer??

                    System.out.println(" enter name");
                    courseArray[k] = courseScan.nextLine();
                    System.out.println(" Enter grade");
                    gradeArray[k] = gradeScan.nextInt();
                    System.out.println(" Do you want to add one more course enter 1, if not enter 0");
                    answer = answerScan.nextInt();
                    k++;
                }
            } else {

                System.out.println("Sorry, there is no more memory");

            }