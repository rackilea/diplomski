val myTry = autoCloseTry(closeable) { resource ⇒
      //doSomethingWithTheResource
      33
    }
    myTry match {
      case Success(result) ⇒ doSomethingWithTheResult(result)
      case Failure(t) ⇒ handleMyExceptions(t)
    }