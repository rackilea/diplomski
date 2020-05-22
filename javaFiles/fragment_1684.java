object ScannerTest {
  def main(args: Array[String]) {
    var ok = true
    while (ok) {
      val ln = readLine()
      ok = ln != null
      if (ok) println(ln)
    }
  }
}