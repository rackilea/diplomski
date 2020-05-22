scala> val r = """(\w{3})-(\p{Alpha})(\d+)-(\w+) \(\d+\)|Conf (\w{3}) (\w+) (\p{Alpha})(\d+)|(.+)""".r

scala> def f(s: String) = s match { case r(city, bld, flr, name, _*) if city != null => s"$name ($city $bld${flr.toInt})"
     | case r(_, _, _, _, city, name, bld, flr, _*) if city != null => s"$name ($city $bld${flr.toInt})" case x => x }
f: (s: String)String

scala> f("Conf DFW Alpha D04")
res8: String = Alpha (DFW D4)

scala> f("DFW-D04-Alpha (10)")
res9: String = Alpha (DFW D4)

scala> f("Something else")
res10: String = Something else