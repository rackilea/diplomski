public Observable<List<Address>> getAddresses(final String userId) {
        return Observable.create(s -> {
            final Address currentAddress = this.getBaseAddress(userId);
            final Address anotherAddress = this.getBaseAddress(userId);
            anotherAddress.setState("NE");
            s.onNext(Arrays.asList(currentAddress, anotherAddress));
            s.onCompleted();
        });