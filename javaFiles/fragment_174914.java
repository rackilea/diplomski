import akka.pattern.ask

case object Request

implicit val timeout = Timeout(5 seconds) // needed for `?` below

// Ask your actors for a result
val f1 = actorA ? Request
val f2 = actorB ? Request
val f3 = actorC ? Request

// for-comprehension
(for {
    x <- f1
    s <- f2
    d <- f3
} yield (f1, f2, f3)).map {
    case (r1, r2, r3) =>
        //Do your stuff with the results
}

// Future.sequence
Future.sequence(f1, f2, f3).map {
    case (r1, r2, r3) =>
        //Do your stuff with the results
}