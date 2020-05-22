lists.sort(new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getName().equals("BOSS")) { 
            if (o2.getName().equals("BOSS")) { return 0; } 
            else { return -1; }
        }
        else if (o2.getName().equals("BOSS")) { return 1; }
        else { return o1.getName().compareTo(o2.getName()); } 
    }
});