interface Context {
    ByteBuffer buffer();
    State state();
    void state(State state);
}
interface State {
    /**
       * @return true to keep processing, false to read more data.
     */
    boolean process(Context context);
}
enum States implements State {
    XML {
        public boolean process(Context context) {
            if (context.buffer().remaining() < 16) return false;
            // read header
            if(headerComplete)
                context.state(States.ROOT);
            return true;
        }
    }, ROOT {
        public boolean process(Context context) {
            if (context.buffer().remaining() < 8) return false;
            // read root tag
            if(rootComplete)
                context.state(States.IN_ROOT);
            return true;
        }
    }
}

public void process(Context context) {
    socket.read(context.buffer());
    while(context.state().process(context));
}