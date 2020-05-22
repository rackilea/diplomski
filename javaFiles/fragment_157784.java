public interface AbstractFilterFactory {
  Params getRequiredParams();
  Filter createFilter(Params params);
}

public interface Params {
 // some interface that describes specific parameters that are required
 // probably a collection of Parameter classes which has name, type and value information. 
}

public class FirstFilterFactory implements AbstractFilterFactory {
  // return a concrete params object use that to instantiate a concrete filter.
}