@Bean
@Qualifier("upperCase")
PrinterDecorator upperCasePrinterDecorator(final Printer printer) { // Injected automatically
   return new UpperCasePrinterDecorator(printer);
}

@Bean
@Qualifier("lowerCase")
PrinterDecorator lowerCasePrinterDecorator(final Printer printer) {
   return new LoweCasePrinterDecorator(printer);
}

@Bean
@Qualifier("asterisk")
PrinterDecorator addAsterisksPrinterDecorator(final Printer printer) {
   return new AddAsterisksPrinterDecorator(printer);
}