ArrayList<Foo> fooList = new ArrayList<Foo>();

void setup() {
  size(400, 400, PDF, "filename.pdf");
  //populate fooList
}

void draw() {

  PGraphicsPDF pdf = (PGraphicsPDF) g;  // Get the renderer

  for(Foo foo : fooList){
    foo.display(pdf); //draw the Foo to the PDF
    pdf.nextPage();  // Tell it to go to the next page
  }
}