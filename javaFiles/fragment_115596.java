/** Encodes a [[java.time.Duration]] into a more readable format.
    *
    * @example
    * encodeDuration(Duration.ofDays(30).plusHours(3))  // returns "30 days, 3 hours"
    * encodeDuration(Duration.ofDays(1))                // returns "1 day"
    * encodeDuration(Duration.parse("PT720H"))          // returns "30 days"
    * encodeDuration(Duration.parse("PT12000H10S"))     // returns "1 year, 4 months, 15 days, 10 seconds"
    */
implicit val encodeDuration: Encoder[java.time.Duration] = (duration: Duration) => {
    val oneMinute = 60
    val twoMinutes = oneMinute * 2
    val oneHour = oneMinute * 60
    val twoHours = oneHour * 2
    val oneDay = oneHour * 24
    val twoDays = oneDay * 2
    val oneMonth = oneDay * 30
    val twoMonths = oneMonth * 2
    val oneYear = oneDay * 365
    val twoYears = oneYear * 2

    // scalastyle:off cyclomatic.complexity
    def encodeDuration(result: List[String], seconds: Long): List[String] = {

      seconds match {
        case seconds if seconds <= 0                                 =>
          List.empty[String]
        case seconds if seconds == 1                                 =>
          result ::: List(s"${seconds} second")
        case seconds if seconds < oneMinute                          =>
          result ::: List(s"${seconds} seconds")
        case seconds if seconds >= oneMinute && seconds < twoMinutes =>
          List(s"${seconds / oneMinute} minute") ::: encodeDuration(result, seconds % oneMinute)
        case seconds if seconds >= oneMinute && seconds < oneHour =>
          List(s"${seconds / oneMinute} minutes") ::: encodeDuration(result, seconds % oneMinute)
        case seconds if seconds >= oneHour && seconds < twoHours     =>
          List(s"${seconds / oneHour} hour") ::: encodeDuration(result, seconds % oneHour)
        case seconds if seconds >= twoHours && seconds < oneDay      =>
          List(s"${seconds / oneHour} hours") ::: encodeDuration(result, seconds % oneHour)
        case seconds if seconds >= oneDay && seconds < twoDays       =>
          List(s"${seconds / oneDay} day") ::: encodeDuration(result, seconds % oneDay)
        case seconds if seconds >= twoDays && seconds < oneMonth     =>
          List(s"${seconds / oneDay} days") ::: encodeDuration(result, seconds % oneDay)
        case seconds if seconds >= oneMonth && seconds < twoMonths   =>
          List(s"${seconds / oneMonth} month") ::: encodeDuration(result, seconds % oneMonth)
        case seconds if seconds >= twoMonths && seconds < oneYear    =>
          List(s"${seconds / oneMonth} months") ::: encodeDuration(result, seconds % oneMonth)
        case seconds if seconds >= oneYear && seconds < twoYears     =>
          List(s"${seconds / oneYear} year") ::: encodeDuration(result, seconds % oneYear)
        case seconds if seconds >= twoYears                          =>
          List(s"${seconds / oneYear} years") ::: encodeDuration(result, seconds % oneYear)
      }
    }
    // scalastyle:on cyclomatic.complexity

    Encoder.encodeString(encodeDuration(List.empty[String], duration.getSeconds).mkString(", "))
  }