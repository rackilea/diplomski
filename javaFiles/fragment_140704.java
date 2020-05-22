final ExecutionContext ec = context().dispatcher();

private void doSomething(ActorRef other){
    Future<Object> decision = (Patterns.ask(other, new String("getDecision"), 1000));
    decision.onSuccess(new OnSuccess<Object>() {
        public void onSuccess(Object result) {
            String resultString = (String) result;
            System.out.println("Decision: " + result);
        }
    }, ec);
}