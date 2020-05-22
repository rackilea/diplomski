case class Notification(message: String, args: String*)

object Notification {

  implicit val anyDecoder : Decoder[Any] =  Decoder.instance(c => {
      c.focus match {
          case Some(x) => Right(x)
          case None => Left(DecodingFailure("Could not parse", List()))
      }
  })

  implicit val messageDecoder: Decoder[Notification] = Decoder.instance(c => {
    for {
      message <- c.downField("message").as[String]
      args <- c.downField("args").as[List[Any]].map(_.toString)
    } yield {
      Notification(message, args)
    }
  })

}