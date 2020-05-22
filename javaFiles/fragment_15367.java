import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

        ...

        String sDate;
        String eDate;

        try (Scanner scan = new Scanner(System.in)) {
           System.out.print("Enter first Date (dd/MM/yyyy): ");
           sDate = scan.nextLine();
           System.out.print("Enter second Date (dd/MM/yyyy): ");
           eDate = scan.nextLine();

        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dateStart = LocalDate.from(format.parse(sDate));
        LocalDate dateEnd = LocalDate.from(format.parse(eDate));
        while (!dateStart.isAfter(dateEnd)) {
            System.out.println(dateStart);
            dateStart = dateStart.plusDays(1);
        }