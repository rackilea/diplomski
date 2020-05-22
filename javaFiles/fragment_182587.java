compositeSubscription.add(yourClass.getUiElementAsObservable()
            .subscribe(new Action1<Integer>() {
                @Override
                public void call(Integer userMessage) {
                    setViews(userMessage,true);
                }
            }));