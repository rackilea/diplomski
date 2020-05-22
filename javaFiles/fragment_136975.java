list = sentinelStorage.readSentinelsListFromDB(dbRef, new FirebaseCallback() {
        @Override
        public void onCallback(List<Sentinel> lst) {
            list.addAll(lst);
            adapter.notifyDatasetChanged();
            Log.d(TAG, "onCallback.Is list empty "+list.isEmpty());// not EMPTY
        }
    });