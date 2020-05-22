val a = "Hello my {name} , how are {{you}}, what should {{I}} {do}"
val pattern = """\{(\{?[^{}]+}?)}""".r
val result = pattern.replaceAllIn(a, m =>
  m.group(1) match {
    case "name" => "nameHere"
    case _ => m.group(1)
  }
)