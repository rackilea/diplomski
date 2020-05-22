package object pimps {

  import java.util.Date
  import org.joda.time.DateTime;
  import org.joda.time.Period;

  def step(f:Period => Int)(fi:String):Period => Option[String] = {
    def g(i:Int = 1) = i + " " + fi + (if (i==1) "" else "s") + " ago"

    (p:Period) => {
      f(p) match {
        case 0 => None
        case 1 => Some(g())
        case x => Some(g(x))
      }
    }
  }
  val yearsStep = step(_.getYears)("year")
  val monthsStep = step(_.getMonths)("month")
  val daysStep = step(_.getDays)("day")
  val hoursStep = step(_.getHours)("hour")
  val minutesStep = step(_.getMinutes)("minute")
  val secondsStep = step(_.getSeconds)("second")
  val steps = Seq(yearsStep, monthsStep, daysStep, hoursStep, minutesStep, secondsStep)

  val check = 
    (p:Period) =>
      steps.collectFirst {
        case f if f(p).isDefined => f(p).get
      }

  implicit class PimpedDate(col: Date) {

    def since() = {
      val period: Period = new Period(new DateTime(col), DateTime.now);
      check(period)
    }
  }
}