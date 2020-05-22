(import java.util.ArrayList)

;// or use a prefix for multiple classes:
(import [java.util ArrayList Collection])

;// or preferably in the ns declaration:
(ns my.lib
  [:import [java.util ArrayList Collection]])

user=> (def al (ArrayList.))
#'user/al
user=> (.add al "hi")
true
user=> (.size al)
1