implicit val propertyTypeDeserializer = 
    new Deserializer[String, PropertyType] {
      def apply(s: String): Deserialized[PropertyType] = {
        Try(PropertyType.valueOf(s)) match {
          case Success(pt) => 
             Right(pt)
          case Failure(err) => 
             Left(MalformedContent("Wrong property type. Accepted values: ${PropertyType.values}", Some(err)))
        }
      }
    }

  def receive: Receive = runRoute {
    path("test") {
      parameter('prop.as[PropertyType]) { case prop =>
        get {
          complete(s"Result: $prop. Class: ${prop.getClass}")
        }
      }
    }
  }