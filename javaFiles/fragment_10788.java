scala> trait T {
     |   trait Q
     | }
defined trait T

scala> class C extends T {
     |   def getQ: this.Q = new this.Q {}
     | }
defined class C

scala> val inC = (new C).getQ
inC: C#Q = C$$anon$1@3f53073a


scala> val c = new C
c: C = C@1a7e4ff0

scala> new c.Q {}
res4: c.Q = $anon$1@36bbb2f5