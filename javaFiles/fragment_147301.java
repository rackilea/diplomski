Printer myPrinter;
ObservableSet<Printer> printers = Printer.getAllPrinters();
for(Printer printer : printers){
    if(printer.getName().matches("spefic printer name")){
        myPrinter = printer;
    }
}