final class Genetics {

    @JsonAdapter(FalseAsNullTypeAdapterFactory.class)
    final String names = null;

    @JsonAdapter(FalseAsNullTypeAdapterFactory.class)
    final String ucpc = null;

    @JsonAdapter(FalseAsNullTypeAdapterFactory.class)
    final URL link = null;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("names", names)
                .add("ucpc", ucpc)
                .add("link", link)
                .toString();
    }

}