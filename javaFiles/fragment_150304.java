function generafechas($date1,$date2){
    $fecharray = array();

    if (is_string($date1) && is_string($date2)){
        // These lines assume the input is formatted `day-month-year`,
        // with 2-digit day and month, and 4-digit year.
        $date1 = DateTime::createFromFormat('d-m-Y', $date1)
        $date2 = DateTime::createFromFormat('d-m-Y', $date2)
    } else {
        throw new InvalidArgumentException('Must provide two date strings');
    }

    // Create the formatter
    $formatter = IntlDateFormatter::create('es_ES', null, null, null, null, "d 'de' MMMM 'del' yyyy");

    do {
        // This line prints the first date in the format you chose above
        $fecharray[] = $formatter->format($date1);
        $date1->add(new DateInterval("P1D")); // `P1D` means "Duration of 1 Day" in the ISO 8601 standard
    } while($date1 <= $date2);

    return $fecharray;
}