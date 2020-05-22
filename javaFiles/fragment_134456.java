try {
    LocalDate ld = LocalDate.of( year , month , dayOfMonth ) ;
    return true ;  // true = Valid data entered for a date.
} catch ( DateTimeParseException e ) {
    return false;  // Exception caught, meaning invalid data-entry.
}