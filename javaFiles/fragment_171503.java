object SoapFaultMessage {
    def unapply(t: Throwable): Option[String] = {
      if (t.getCause != null && t.getCause.isInstanceOf[SoapFault]) {
        Some(t.getCause.asInstanceOf[SoapFault].getMessage)
      } else {
        None
      }
    }
  }