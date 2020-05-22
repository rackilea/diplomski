import groovy.lang.Binding;
import groovy.lang.MetaClass;
import groovy.lang.MissingMethodException;

import org.codehaus.groovy.runtime.InvokerHelper;

import java.util.HashMap;
import java.util.Map;


public abstract class MultiDelegatingScript extends groovy.lang.Script {

  private final Map<Object, MetaClass> delegateMap = new HashMap<>();

  protected MultiDelegatingScript() {
    super();
  }

  protected MultiDelegatingScript(Binding binding) {
    super(binding);
  }

  public void setDelegate(Object delegate) {
    this.delegateMap.put(delegate, InvokerHelper.getMetaClass(delegate.getClass()));
  }

  @Override
  public Object invokeMethod(String name, Object args) {
    for (Map.Entry<Object, MetaClass> delegate : this.delegateMap.entrySet()) {
      try {
        // Try to invoke the delegating method
        return delegate.getValue().invokeMethod(delegate.getKey(), name, args);
      } catch (MissingMethodException mme) {
        // Method not found in delegating object -> try the next one
        continue;
      }
    }

    // No delegating method found -> invoke super class method for further handling
    return super.invokeMethod(name, args);
  }

}