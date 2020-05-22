system.scheduler().scheduleOnce(Duration.create(20, TimeUnit.SECONDS),
    new Runnable() {
        @Override
        public void run() {
            testActor.tell(PoisonPill.getInstance(), ActorRef.noSender());
        }
    }, system.dispatcher());