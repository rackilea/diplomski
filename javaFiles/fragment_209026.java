@Provides
@MyBindingAnnotation
@Singleton
BlockingQueue<String> provideBlockingQueue(MyGuiceManagedConfig config){
    return new LinkedBlockingQueue<String>(config.getCapacity());
}