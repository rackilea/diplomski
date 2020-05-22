public class CalendarUI {
    public static String Dias[] = { "", "DOM", "SEG", "TER", "QUA", "QUI", "SEX", "SAB" };
    public static String Meses[] = { "JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ" };

    public static void printCalendar(int currMonth){
        int i = 1;      
        Calendar c = Calendar.getInstance();
        NumberFormat formatter = new DecimalFormat("##00");


        c.set(Calendar.YEAR, 2009);
        c.set(Calendar.MONTH, currMonth);
        c.set(Calendar.DATE, i);

        // cabecalho com o mes
        System.out.println(" - " + Meses[currMonth] + " - ");

        // ajuste para o primeiro dia
        for (; i < c.get(Calendar.DAY_OF_WEEK); i++) {
            System.out.print("           ");
        }

        // principal
        for (i = 1; i <= 31; i++) {
            c.set(Calendar.DATE, i);

            if (c.get(Calendar.MONTH) == currMonth) {       
                if (c.get(Calendar.DAY_OF_WEEK) == 1)
                    System.out.println("");

                System.out.print("[ " + Dias[c.get(Calendar.DAY_OF_WEEK)]
                        + ", " + formatter.format(i) + " ]");
            }
        }       

        System.out.println("\n\n");
    }

    public static void main(String[] args) {
        for (int j = 0; j < 12; j++) {
            CalendarUI.printCalendar(j);

        }

    }