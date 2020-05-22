import java.util.Set;

interface System<R extends Router, C extends Component, I extends Interactor> {
    Set<R> routers(I interactor);
    Set<R> routers(C component);
    Set<I> interactors(R router);
    Set<I> interactors(C component);
    Set<C> components(R router);
    Set<C> components(I interactor);
}

abstract class Router {}

abstract class Interactor {}

abstract class Component { }