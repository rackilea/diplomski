System.out.print("Enter number of guests:(Max of 4 per room) ");
                int guests = scand.nextInt();
                String[] guestName = new String[guests];
                for (int i=0;i<guestName.length;i++) {
                    System.out.print("Enter guest names: ");
                    guestName[i] = scand.next();
            }