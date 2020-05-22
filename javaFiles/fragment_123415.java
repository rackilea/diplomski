@Override
    public Loader<Cursor> onCreateLoader(int loaderId, Bundle args) {
        Loader<Cursor> loader = null;
        switch (loaderId) {
            case LOADER_ORDERS:
                System.out.println("Create loader called");
                loader = new CursorLoader(OrderManagerApplication.getAppContext(), OrderManagerContract.Order.CONTENT_URI,
                        QueryOrder.PROJECTION_SIMPLE, null, null, OrderManagerContract.Order.DATE_SORT);

                if (subscription != null && !subscription.isUnsubscribed()) {
                    subscription.unsubscribe();
                }

                subscription = AndroidObservable
                        .bindFragment(this, DatabaseHelper.mainOrdersObservable(data))
                        .subscribeOn(Schedulers.computation())
                        .unsubscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(mObjectiveObserver);
                break;
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (getActivity() == null) {
            return;
        }

        if (data != null && !data.isClosed()) {
            System.out.println("Finished loading orders, data not null");
            switch (loader.getId()) {
                case LOADER_ORDERS:
                    mObjectiveObserver.onNext(data);
                    System.out.println("I should be here, onLoadFinished");
                    break;
            }
        } else {
            mObjectiveObserver.onError("No data available");
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }