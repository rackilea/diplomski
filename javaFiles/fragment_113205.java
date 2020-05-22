public class ProcessTest {

    <T extends Base> void processBase(T base) {
        ProcessorFactory.getProcessor(base).process(base);
    }

}


interface Base{
}
class X implements Base{
}
class Y implements Base{
}

interface Processor<E extends Base>{
    void process(E object);
}

interface XProcessor extends Processor<X> {

}
interface YProcessor extends Processor<Y> {

}

class ProcessorFactory {

    @SuppressWarnings("unchecked")
    static <T extends Base> Processor<T> getProcessor(T base) {
        if (base instanceof X) {
            return (Processor<T>) new XProcessorImpl();
        }
        return null;
    }

}

class XProcessorImpl implements XProcessor {

    @Override
    public void process(X object) {
        // TODO Auto-generated method stub

    }

}