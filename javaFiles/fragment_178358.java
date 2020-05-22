final class Envelope {

    final Genetics genetics = null;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("genetics", genetics)
                .toString();
    }

}