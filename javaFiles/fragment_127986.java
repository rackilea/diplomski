class Categorizer {

 void accept(String s) { println "String: '$s'" }
 void accept(Number n) { println "Number: $n" }
 void accept(Object o) { println "Object: $o" }

 void accept(Object... objects) {
    objects.each {
      accept(it)
    }
  }
}

new Categorizer().accept(
  "a",
  "${'b'}",
  1,
  true,
  ["c", "d", 2] as Object[]
)