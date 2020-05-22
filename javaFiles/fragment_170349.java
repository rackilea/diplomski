public class DoubleParamGeneric {

    public <C extends CInterface, R extends RInterface> List<C>  m(R r) {

        List<C> result = null; 

        // Process here

        return result;

    }
}

public interface CInterface {

}

public interface RInterface {

}