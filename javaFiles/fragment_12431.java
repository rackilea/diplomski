final class Response {

    @SerializedName("progress")
    @JsonAdapter(FalseAsNullTypeAdapterFactory.class)
    final Progress progress = null;

}

final class Progress {

    final String foo = null;

}