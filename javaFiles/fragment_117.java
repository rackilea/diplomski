Single.fromCallable(new Callable<Product>() {

            @Override
            public Product call() throws Exception {
                return threadStore.getThreadRepository()
                    .getThreadPersister()
                    .getProductByStyleColorSuspended(detailOrder.getStyleColor())
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn (AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Object>() {
                    @Override
                    public void onSuccess(Object o) {
                        if (product != null) {
                            final DeferredPaymentOrder deferredPaymentOrder =
                                mSnkrsDatabaseHelper.getDeferredPaymentOrder(detailOrder.getId());
                            if (deferredPaymentOrder != null && deferredPaymentOrder.isWaiting()) {
                              mTopButton.setVisibility(View.VISIBLE);
                              mTopButton.setText(R.string.cta_go_fund);
                              mTopButton.setOnClickListener(
                                  v -> ((BaseActivity) getActivity()).fundDeferredPaymentOrder(product,
                                      AnalyticsAction.ORDER_DETAILS_FUND));
                            } else {
                              mTopButton.setVisibility(View.GONE);
                            }
                          } else {
                            mTopButton.setVisibility(View.GONE);
                          }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });