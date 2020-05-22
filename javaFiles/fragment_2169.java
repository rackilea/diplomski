public class RegularPrice extends Price {

     RegularPrice(int p){ 
         //many ways to do this, but use costructors to set members
         super(p); 
      } 

    public double getAmount(int rentalDays) {
        double res = 2;
        if (rentalDays > 2)
            res += (rentalDays - 2) * 1.5;
        return res;
    }

}