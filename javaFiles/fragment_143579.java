class ThingThatUsesStreamCopier {

    // our copier instance. set in constructor, but might equally use
    // a setter for this:
    private StreamCopier copier;

    public ThingThatUsesStreamCopier(StreamCopier copier) {
        this.copier = copier;
    }

    public void makeCopy(Stream in, Stream out) {
        // probably something a little less trivial...
        copier.copy(in, out);
    }
}