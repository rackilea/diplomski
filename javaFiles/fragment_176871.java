val os: Option[Seq[String]] = for {
  m <- formValues
  v <- m.get(key)
} yield v

os.foreach { v => \\ do something with the value }