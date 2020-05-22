public void registerEventListener() {
    final ObjectOfInterest currentO = this.o;
    EventEmitter.onEvent(() -> {
        currentO.yeeha();
    });
}