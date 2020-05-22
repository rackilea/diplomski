import akka.actor.ActorSystem;
    import akka.dispatch.Futures;
    import akka.dispatch.OnComplete;
    import scala.concurrent.Future;
    import scala.runtime.BoxedUnit;

    final ActorSystem sys = ActorSystem.create();

    final Future<String> successful = Futures.successful("");
    successful.onComplete(new OnComplete<String>() {
        @Override
        public void onComplete(Throwable failure, String success) throws Throwable {

        }
    }, sys.dispatcher());