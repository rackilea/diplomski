public static F.Promise<Result> love() {
    ExecutionContext myExecutionContext = Akka.system().dispatchers().lookup("play.akka.actor.my-context");

    F.Promise<Integer> integerPromise = F.Promise.promise(() ->
            LongRunningProcess.run(10000L)
    , myExecutionContext);

    F.Promise<Integer> integerPromise2 = F.Promise.promise(() ->
            LongRunningProcess.run(10000L)
    , myExecutionContext);

    return integerPromise.flatMap(i -> integerPromise2.map(x -> ok()));
}