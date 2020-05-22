public int compare(Empl e1, Empl e2) {
        if(e1.getName().equals(e2.getName())) {
            return 0;
        }else if(e1.getSalary() > e2.getSalary()){
            return 1;
        }else if(e1.getSalary() == e2.getSalary() && (e1.getName().compareTo(e2.getName()) > 1)) {
             return 1; // if the salary is equal, sort it based on name.
        }
        else {
            return -1;
        }

    }