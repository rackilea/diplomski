int getDay( String date, String format='yyyy/MM/dd' ) {
  Calendar.instance.with {
    time = new java.text.SimpleDateFormat( format ).parse( date )
    get( Calendar.DAY_OF_MONTH )
  }
}

def date = '2012/05/25'
assert 25 == getDay( date )