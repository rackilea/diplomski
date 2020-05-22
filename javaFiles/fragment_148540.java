public static boolean eligibleForRetirement(Customer c) {
        if (c.getAge() >= 65) { 
            return true;
        } else {
           return false;
        }
    }