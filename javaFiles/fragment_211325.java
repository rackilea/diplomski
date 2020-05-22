HazelcastInstance client = HazelcastClient.newHazelcastClient();
    client.getLifecycleService().addLifecycleListener(new LifecycleListener() {
        @Override
        public void stateChanged(LifecycleEvent event) {

        }
    })