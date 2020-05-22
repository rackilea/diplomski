case class TestObj(name: String, testList: Seq[String])

object Driver extends App {

  // Setup the test list data
  val tList = Seq(TestObj("test", Seq("1", "2")))

  // Convert the list to a new data structure
  val l3 = for {
      t <- tList
      if t.name equalsIgnoreCase "test"
      lv <- t.testList
    } yield Seq(lv)

  // Output the values of the new data structure
  for (listVals <- l3) {
    for (strVal <- listVals) {
      println("strval is " + strVal)
    }
    println("New list")
  }

}