// create the formatter for the first half
DateTimeFormatter a = DateTimeFormatter.ofPattern("dd")

// setup a ParsePosition to keep track of where we are in the parse
ParsePosition pp = new ParsePosition();

// parse the date, which will update the index in the ParsePosition
String str = "31xy 03 2016";
int dom = a.parse(str, pp).get(DAY_OF_MONTH);

// some logic to skip the messy 'xy' part
// logic must update the ParsePosition to the start of the month section
pp.setIndex(???)

// use the parsed day-of-month in the formatter for the month and year
DateTimeFormatter b = DateTimeFormatter.ofPattern("MM yyyy")
    .parseDefaulting(DAY_OF_MONTH, dom);

// parse the date, using the *same* ParsePosition
LocalDate date = b.parse(str, pp).query(LocalDate::from);