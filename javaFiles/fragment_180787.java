public class YearsComp implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int returnValue = 0;
        if (o1.getYearsSpentInCompany() > o2.getYearsSpentInCompany()) {
            returnValue = 1;
        } else if (o1.getYearsSpentInCompany() < o2.getYearsSpentInCompany()) {
            returnValue = -1;
        }
        return returnValue;
    }
}