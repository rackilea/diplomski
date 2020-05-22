import scala.sys.process._

Seq("scala", "slow-printer.scala").run(new ProcessIO(
  _.close(), // stdin
  out => { // stdout
    val src = scala.io.Source.fromInputStream(out)
    for (line <- src.getLines()) {
      println(line)
    }
  },
  _.close() // stderr
))