public Observable<List<Chat>> getChats(int userId) {

    Log.i("chatRequest", TAG);

    return Observable.merge(chatDiskData.getChats(), chatDiskData.getChats().flatMap(new Function<RealmResults<Chat>, ObservableSource<List<Chat>>>() {
        @Override
        public ObservableSource<List<Chat>> apply(@NonNull RealmResults<Chat> chats) throws Exception {

            Log.i("chatRequest", TAG + "  inside");

            ArrayList<String> chatIds = new ArrayList<>();
            HashMap<String, Long> chatsTimeStamp = new HashMap<>();

            for (int i = 0; i < chats.size(); i++) {
                String chatId = chats.get(i).getChat_id();
                chatIds.add(chatId);

                long timestamp = chatDiskData.lastMessage(chatId);
                chatsTimeStamp.put(chatId, timestamp);
            }

            return Observable.fromCallable(new Callable<List<Chat>>() {
                @Override
                public List<Chat> call() throws Exception {
                    return chatCloudData.getChats(userId, chatIds, chatsTimeStamp).subscribeOn(Schedulers.io())
                    .doOnNext(chats1 -> Log.i("chatRequest", TAG + "  inside  inside"));
                }
            });
        }
    }));
}