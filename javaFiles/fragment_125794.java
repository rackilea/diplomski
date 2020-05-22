object NonWwwFilter extends Filter {

  def apply(f:RequestHeader => Future[Result])(rh: RequestHeader): Future[Result] =
    if (rh.host.startsWith("www.")) {
      Future.successful(Results.MovedPermanently("https://" + rh.host.substring(4) + rh.uri))
    } else {
      f(rh)
    }
}