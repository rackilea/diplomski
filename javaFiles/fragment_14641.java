boolean flag = true;
            int counter = 3;
            while(flag)
            {
                if (pass.equals(test))
                {
                    System.out.print("Access granted");
                    break;  // Permission granted so out of the Loop
                }
                else if(counter==0)
                {
                    flag = false;
                    break;
                }

                System.out.print("You have "+counter+" try(es): ");
                test = input.nextLine();
                counter--;
            }

            if(!flag)
            {
                System.out.print("Access denied");
            }