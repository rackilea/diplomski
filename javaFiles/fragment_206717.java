public abstract class AbstractBaseThing<T extends AbstractBaseThing<T>> extends BaseOfAllIDNeedingObjects implements ID<T> {
    /* base thing stuff here */
}

public class BaseThing extends AbstractBaseThing<BaseThing> {
    /* concrete base thing */
}

public class SpecificThing extends AbstractBaseThing<SpecificThing> {
    /* specific things */
}