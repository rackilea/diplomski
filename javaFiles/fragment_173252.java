class MyStringUtils {
  static List allIndexOf( String str, pattern ) {
    def ret = []
    str.findAll pattern, { s ->
      def idx = -2
      while( ( idx = str.indexOf( s, idx + 1 ) ) >= 0 ) {
        ret << idx
      }
    }
    ret
  }
}

use( MyStringUtils ) {
  "Finds all occurrences of a regular expression string".allIndexOf( /a[lr]/ )
}