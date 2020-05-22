@Component
class Config {

 public static String numberOfBooks;

 @Value("${number.of.books}")
 public void setNumberOfBooks(String numberOfBooks) {
    numberOfBooks = numberOfBooks;
 }
}