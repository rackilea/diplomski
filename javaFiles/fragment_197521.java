public static Person login(ArrayList<Person> per, String password, int idint) {
        //null list or empty list
        if(per == null || per.size() == 0)
            return null;
        for (Person currentPerson : per) {
            if (idint == currentPerson.Id) {
                if (currentPerson.password.equals(password)) {
                    System.out.println("Login Succesfully!");
                    return currentPerson;
                } else {
                    System.out.println("Incorrect password. Try again");
                    return null;
                }
            } else {
                System.out.println("User not found. Try again");
                return null;
            }
        }
        //Person is not present in the list
        return null;

    }