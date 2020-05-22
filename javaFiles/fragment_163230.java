DoWithId callback = new DoWithId() {
        @Override
        public void doWithId(long id) {
            launchIntentWithId(id)
        }
    };
    new InsertCbtAsyncTask(cbtDao, callback).execute(cbtTable);