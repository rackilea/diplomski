public class SentenceStream extends Spliterators.AbstractSpliterator<String>
implements Consumer<CharSequence> {

    public static Stream<String> sentences(Stream<? extends CharSequence> s) {
        return StreamSupport.stream(new SentenceStream(s.spliterator()), false);
    }
    Spliterator<? extends CharSequence> source;
    CharBuffer buffer;
    BreakIterator iterator;

    public SentenceStream(Spliterator<? extends CharSequence> source) {
        super(Long.MAX_VALUE, ORDERED|NONNULL);
        this.source = source;
        iterator=BreakIterator.getSentenceInstance(Locale.ENGLISH);
        buffer=CharBuffer.allocate(100);
        buffer.flip();
    }

    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        for(;;) {
            int next=iterator.next();
            if(next!=BreakIterator.DONE && next!=buffer.limit()) {
                action.accept(buffer.subSequence(0, next-buffer.position()).toString());
                buffer.position(next);
                return true;
            }
            if(!source.tryAdvance(this)) {
                if(buffer.hasRemaining()) {
                    action.accept(buffer.toString());
                    buffer.position(0).limit(0);
                    return true;
                }
                return false;
            }
            iterator.setText(buffer.toString());
        }
    }

    @Override
    public void accept(CharSequence t) {
        buffer.compact();
        if(buffer.remaining()<t.length()) {
            CharBuffer bigger=CharBuffer.allocate(
                Math.max(buffer.capacity()*2, buffer.position()+t.length()));
            buffer.flip();
            bigger.put(buffer);
            buffer=bigger;
        }
        buffer.append(t).flip();
    }
}