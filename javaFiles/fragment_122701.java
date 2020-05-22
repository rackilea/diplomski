AsyncSession asyncSession = App.getInstance().daoSession.startAsyncSession();
    asyncSession.setListener(new AsyncOperationListener() {
        @Override
        public void onAsyncOperationCompleted(AsyncOperation operation) {
            itemsList = (List<MyObject>) operation.getResult();
        }
    });
    asyncSession.loadAll(MyObject.class);