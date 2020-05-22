@BeforeClass
public static void setup() {
    System.out.println("in setup()");
    bookMap.put("0553293354", "Foundation");
    bookMap.put("0836220625", "The Far Side Gallery");

    new MockUp<BookStoreService>() {            
        @Mock
        public String getBookTitle(String isbn) {
            System.out.println("in getBookTitle()");
            if (bookMap.containsKey(isbn)) {
                return bookMap.get(isbn);
            } else {
                return null;
            }
        }
    };
}