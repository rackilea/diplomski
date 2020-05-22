@Provides
SomeObject providesSomeObject() {
    return new SomeObject();
}

// THIS “Context” here is automatically injected by Dagger thanks to the above.
@Provides
@Singleton
SomeOtherObject providesSomeOtherObject(Context context) {
    return new SomeOtherObject(context); //assume this one needs it
}