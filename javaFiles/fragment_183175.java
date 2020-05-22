void method(){
    BufferStrategy bs = this.getBufferStrategy();;
    if(bs == null) {
        createBufferStrategy(3);
        return;
    }
}