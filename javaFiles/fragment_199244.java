public class DateCompartor implements Comparator<BirthdayContact> {

    @Override
    public int compare(BirthdayContact arg0, BirthdayContact arg1) {

        Date now=new Date();    
        // Read Sun's Java coding standards; these don't follow the standard.                         
        Date bd1=arg0.GetBirthDay();  
        Date bd2=arg1.GetBirthDay();
        long dist1 = Math.abs(bd1.getTime() - now.getTime());
        long dist2 = Math.abs(bd2.getTime() - now.getTime());
        return dist1.compareTo(dist2); // Might need wrapper Long here.

    }

}