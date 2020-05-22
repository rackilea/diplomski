public class X {

    private State state;

    // constructor to instantiate state

    void OnClickEvent() {
        if (state.getCalledTimes() <= 5) {
            state.incrementCalledTimes();
            state.setEx(true);
        } else
            state.setEx(false);
    }

}