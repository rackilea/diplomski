// generic interface declaration
public interface IAction<T extends ISignal, S extends IState> {
    void doAction(T sig, S state);
}

// typed implementations of the generic interface
public class Action1 implements IAction<Signal1, State1> {
    doAction(Signal1 sig, State1 state) {
        // impl
    }
}

// another typed implementations of the generic interface
public class Action2 implements IAction<Signal2, State2> {
    doAction(Signal2 sig, State2 state) {
        // impl
    }
}