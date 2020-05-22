public class SalePerson implements Comparable<SalePerson>{

    @Override
    public int compareTo(SalePerson o) {
        int totalSalesCompare = Integer.compare(this.totalSales, o.getTotalSales());
        return totalSalesCompare == 0 ? this.lastName.compareTo(o.getLastName()) 
                : totalSalesCompare;

    }
}