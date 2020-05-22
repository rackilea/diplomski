private static void searchRecord(String firstName, String lastName) {
        boolean recordFound = false;
        if(fName.contains(firstName) && lName.contains(lastName)){
            int index = -1; 

            for (String fn : fName) {
                index++;
                if(fn.equals(firstName)){
                    String ln = lName.get(index);
                    if(ln.equals(lastName)){
                        recordFound = true;
                        System.out.println("Record Found");
                        System.out.println("First Name="+ fName.get(index));
                        System.out.println("Last Name="+ lName.get(index));
                        System.out.println("Phone="+ phone.get(index));
                        System.out.println("Balance="+ balance.get(index));
                    }
                }
            }

        } 
        if(!recordFound) {
            System.out.println("No Record found for first name="+ firstName + " and last name="+lastName);
        }

    }