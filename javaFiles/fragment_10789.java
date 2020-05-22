scala> object T {
     |   trait Q {
     |     def implementMe: Unit
     |   }
     | }
defined module T

scala> val inT = new T.Q {
     |   def implementMe = println("implemented!")
     | }
inT: T.Q = $anon$1@20f2a08b

scala> inT.implementMe
implemented!