object RedirectFilter extends Filter {

  def apply(next: RequestHeader => Result)(request: RequestHeader): Result = {

    getRedirectParams(request).flatMap { case (newRequest, body) =>
      route(newRequest).map { iteratee =>
        AsyncResult(Enumerator(body).run(iteratee))
      }
    } getOrElse {
      next(request)
    }
  }

  private def getRedirectParams(request: RequestHeader): Option[(RequestHeader, Array[Byte])] = {
    if (someCondition) {
      Some(toPostRequest(request), "Some new body data".getBytes("UTF-8"))      
    } else {
      None
    }
  }

  private def toPostRequest(originalRequest: RequestHeader): RequestHeader = {
    originalRequest.copy(
      uri = "/some/new/uri",
      path = "/some/new/uri",
      method = "POST"
    )
  }

  private def route(request: RequestHeader): Option[Iteratee[Array[Byte], Result]] = {
    Play.global.onRouteRequest(request).collect {
      case action: EssentialAction => Play.global.doFilter(action)(request)
    }
  }

}