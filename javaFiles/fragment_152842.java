public class Age {

public static void main(String[] args) {
        Calendar birthDate = new GregorianCalendar(1979, 1, 1); 
        Calendar deathDate = new GregorianCalendar(2011, 1, 1);
        int age = deathDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        if ((birthDate.get(Calendar.MONTH) > deathDate.get(Calendar.MONTH))
            || (birthDate.get(Calendar.MONTH) == deathDate.get(Calendar.MONTH) && birthDate.get(Calendar.DAY_OF_MONTH) > deathDate
                .get(Calendar.DAY_OF_MONTH))) {
          age--;
        }
        System.out.println(age);
      }