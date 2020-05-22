public static void main(String[] args) {
  /** let's use the following zip code simply for the purpose of this 
      example (its the zip code for hollywood callifornia) */
  String zipCode = 91601
  String latitude = "0";
  String longitude = "0";
try {
                    /**
                      JavaCVS api is required in order to read this, it can
                      be found at http://sourceforge.net/projects/javacsv/
                     **/
        CsvReader products = new CsvReader("zips.csv");
                    /** a cvs containing all the zip codes and latitudes
                        and longitudes can be found at: 
                        http://sourceforge.net/projects/zips/files/zips/zips.csv.zip/
                    **/
        products.readHeaders();
        int numOfHeaders = products.getHeaderCount();
        System.out.println("Number of headers" + numOfHeaders);
        try {
            while (products.readRecord())
            {

            String lookedupZip = products.get(products.getHeader(0));
            if (lookedupZip.equals(zipCode)) {
                latitude = products.get(products.getHeader(2));
                longitude = products.get(products.getHeader(3));
            }

            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    } catch (IOException e2) {
        e2.printStackTrace();
    }
}