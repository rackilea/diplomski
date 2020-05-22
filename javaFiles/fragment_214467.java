scala> val gs = List("name", "city", "bld")
gs: List[String] = List(name, city, bld)

scala> val r = """(?<city>\w{3})-(?<bld>\p{Alpha}\d+)-(?<name>\w+) \(\d+\)|Conf (?<city2>\w{3}) (?<name2>\w+) (?<bld2>\p{Alpha}\d+)|(?<other>.+)""".r
r: scala.util.matching.Regex = (?<city>\w{3})-(?<bld>\p{Alpha}\d+)-(?<name>\w+) \(\d+\)|Conf (?<city2>\w{3}) (?<name2>\w+) (?<bld2>\p{Alpha}\d+)|(?<other>.+)

scala> def f(s: String) = {
     | val m = r.pattern matcher s
     | if (!m.matches) "" else Option(m group "other") getOrElse {
     | val ns = if (m.group("city") == null) gs map (_ + "2") else gs
     | "%s (%s %s)".format(ns map m.group : _*)
     | }}
f: (s: String)String

scala> f("DFW-D04-Alpha (10)")
res20: String = Alpha (DFW D04)

scala> f("Conf DFW Alpha D04")
res21: String = Alpha (DFW D04)

scala> f("other")
res22: String = other