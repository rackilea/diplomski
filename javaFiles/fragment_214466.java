scala> val r = """(?<city>\w{3})-(?<bld>\p{Alpha}\d+)-(?<name>\w+) \(\d+\)|Conf (?<city2>\w{3}) (?<name2>\w+) (?<bld2>\p{Alpha}\d+)|(.+)""".r
r: scala.util.matching.Regex = (?<city>\w{3})-(?<bld>\p{Alpha}\d+)-(?<name>\w+) \(\d+\)|Conf (?<city2>\w{3}) (?<name2>\w+) (?<bld2>\p{Alpha}\d+)|(.+)

scala> val m = r.pattern matcher "DFW-D04-Alpha (10)"
m: java.util.regex.Matcher = java.util.regex.Matcher[pattern=(?<city>\w{3})-(?<bld>\p{Alpha}\d+)-(?<name>\w+) \(\d+\)|Conf (?<city2>\w{3}) (?<name2>\w+) (?<bld2>\p{Alpha}\d+)|(.+) region=0,18 lastmatch=]

scala> if (m.matches && m.group("city") != null) "%s (%s %s)".format(m.group("name"), m.group("city"), m.group("bld"))
res16: Any = Alpha (DFW D04)