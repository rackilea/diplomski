abstract class Router<
    R extends Router<R,C,I>, C extends Component<R,C,I>, I extends Interactor<R,C,I>
> { }

abstract class Interactor<
    R extends Router<R,C,I>, C extends Component<R,C,I>, I extends Interactor<R,C,I>
> { }

abstract class Component<
    R extends Router<R,C,I>, C extends Component<R,C,I>, I extends Interactor<R,C,I>
>  { }