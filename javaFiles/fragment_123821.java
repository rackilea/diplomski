@Singleton
@Provides
// You would also have to provide the path from somewhere or hardcode it
// left as an exercise for the reader
CalligraphyManager provideCalligraphyManager(Context context, String path) {
    return new ActualCalligraphyManager(context, path);
}