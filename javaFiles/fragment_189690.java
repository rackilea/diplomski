PdfReader reader = new PdfReader(
            "C:/anil/code/StackOverFlow/res/mySample.pdf");
int number_of_pages = reader.getNumberOfPages();
System.out.println("Number of pages is ...."+number_of_pages);
for (int i = 0; i < number_of_pages; i++) {
        System.out.println("Inside for loop");
}