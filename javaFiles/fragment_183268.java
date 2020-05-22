final class Response<T> {

    // Note a few things:
    // - Gson can deserialize final fields, and these are incoming data supposed to be read-only
    // - There are no getters for brevity, these are just incoming data bags anyway
    // - If `final`, primitive types like `int` should not be initialized with `0` (javac inlines such constants)
    //   so we're cheating making them look like constants...
    @SerializedName("page") final int page = Integer.valueOf(0);
    @SerializedName("pages") final int pages = Integer.valueOf(0);
    @SerializedName("rows") final List<T> rows = null;
    @SerializedName("total") final int total = Integer.valueOf(0);

}