public enum History {
    US_DECLARATION_OF_INDEPENDENCE( LocalDate.of( 1776 , Month.July , 4 ) ) ,
    US_CONSTITIUTION_APPROVED( LocalDate.of( 1787 , 9 , 17 ) ) 
    ;

    private LocalDate localDate ;

    // Constructor
    public History( LocalDate ld ) {
        Objects.requireNonNull( ld ) ;
        this.localDate = ld ;
    }

    // Getter
    public LocalDate getLocalDate() {
        return this.localDate ;
    }

}