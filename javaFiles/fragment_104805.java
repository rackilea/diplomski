public final class MyServiceImpl implements MyService { 
    @Override
    public long getTime() {
        return System.currentTimeMillis();
    } 
}