public int compareTo(Franchise that) {
    int stateComparition = this.getLocation().compareTo(that.getLocation()); 
    Double sales = Double.valueOf(this.getTotal());    
    Double thatSales = Double.valueOf(that.getTotal());
    int salesComparition = sales.compareTo(thatSales);    

    if(stateComparition == 0){
        if(salesComparition > 0)
             return -1;
        else if(salesComparition < 0)
             return 1;
        else
             return 0;
    }
       return stateComparition;         
}