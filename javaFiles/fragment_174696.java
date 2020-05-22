public class DataModel {
    public List<Email> loadData() {

        List<Email> emailList = new ArrayList<>();

        emailList.addAll(
                Arrays.asList(
                        new Email(1, "Smith", "John", "Casa", "BLAAAAAAAAAAAAA", new Date(1997, 3, 2)),
                        new Email(2, "Isabella", "Johnson", "Bua", "BUUUUUUU", new Date(1995, 6, 2)),
                        new Email(3, "Ethan", "Williams", "Rapporto", "IIIIIIIIII", new Date(2011, 9, 8)),
                        new Email(4, "Emma", "Jones", "Chiesa", "ALEEEEEEEEEE", new Date(2000, 1, 4)),
                        new Email(5, "Pippo", "Brown", "Vignetta", "OSAAAAAAAA", new Date(1987, 4, 5))
                )
        );

        return emailList;
    }
}