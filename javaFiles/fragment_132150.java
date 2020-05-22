Collections.sort(empArray, new Comparator<Object>() {

    public int compare(Object obj0, Object obj1) {
        // TODO Auto-generated method stub
        Employee one = (Employee) obj0; 
        Employee two = (Employee) obj1;
        return one.getId().compareTo(two.getId());
    }
});