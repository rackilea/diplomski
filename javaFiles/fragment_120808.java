public static void main(String[] args) throws Exception {

    try(EasyTest easy = new EasyTest(DriverType.CHROME)) {


        easy.start("http://preview.harriscountyfws.org/");

        easy.newPage(page -> {
           page.click("span[aria-owns='ddlGage_listbox']");

           final String searchText = "110:A100_110 Clear Creek @ I-45";
           page.executeIn("#ddlGage_listbox", container -> {
               page.click("//li[text()='" + searchText + "']");
           });

        });
    }
}