for (i = 0; i < cyclesCount; i++) {
    someServerRequest.executeWithListener(new CustomListener() {
        @Override
        public void onComplete(Integer response) {
            arrayList.add(new Result(i, response));
        }
    });
}