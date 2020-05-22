public class OlympicsDataFinder {
   public static void main(String[] not_in_use) {
    Olympics[] olympics_table = {
        new Olympics(1896, "Athens", "Greece"),
        new Olympics(1900, "Paris", "France"),
        new Olympics(1904, "St. Louis", "U.S.A."),
        new Olympics(1906, "Athens", "Greece"),
        new Olympics(1908, "London", "Great Britain"),
        new Olympics(1912, "Stockholm", "Sweden"),
        new Olympics(1920, "Antwerp", "Belgium"),
        new Olympics(1924, "Paris", "France"),
        new Olympics(1928, "Amsterdam", "Netherlands"),
        new Olympics(1932, "Los Angeles", "U.S.A."),
        new Olympics(1936, "Berlin", "Germany"),
        new Olympics(1948, "London", "Great Britain"),
        new Olympics(1952, "Helsinki", "Finland"),
        new Olympics(1956, "Melbourne", "Australia"),
        new Olympics(1960, "Rome", "Italy"),
        new Olympics(1964, "Tokyo", "Japan"),
        new Olympics(1968, "Mexico City", "Mexico"),
        new Olympics(1972, "Munich", "West Germany"),
        new Olympics(1976, "Montreal", "Canada"),
        new Olympics(1980, "Moscow", "Soviet Union"),
        new Olympics(1984, "Los Angeles", "U.S.A."),
        new Olympics(1988, "Seoul", "South Korea"),
        new Olympics(1992, "Barcelona", "Spain"),
        new Olympics(1996, "Atlanta", "U.S.A."),
        new Olympics(2000, "Sydney", "Australia"),
        new Olympics(2004, "Athens", "Greece"),
        new Olympics(2008, "Beijing", "China"),
        new Olympics(2012, "London", "Great Britain"),};


    System.out.print("\n This program can tell where the Olympic "
            + "\n Games were held in a given year. Give "
            + "\n a year by using four digits: ");

    Scanner keyboard = new Scanner(System.in);
    int given_year = keyboard.nextInt();

    int olympics_index = 0;

    boolean foundrecord = false;

    while (true) {
        if (olympics_index >= olympics_table.length) {
            break;
        }
        if (olympics_table[olympics_index].get_year() == given_year) {
            olympics_table[ olympics_index].print_olympics_data();
            foundrecord=true;
            break;
        }
        olympics_index++;
    }

    if (!foundrecord) {
        System.out.print("\n Sorry, no Olympic Game was held in "
                + given_year + ".\n");
    }
}
}