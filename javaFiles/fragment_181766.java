object ScalaConverter {
  class ScalaApp[T](val block: AppContext => T) extends App[T] {
    def process(context: AppContext): T = block(context)
  }

  implicit class ScalaClient(client: Client) extends AnyVal{
    def execute[T](block: AppContext => T): Future[T] = {
      client.execute(new ScalaApp(block))
    }
  }
}