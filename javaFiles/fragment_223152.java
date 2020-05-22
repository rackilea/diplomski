import org.codehaus.groovy.runtime.NullObject

    String.metaClass.formatx = { -> delegate.toString().replaceAll(/null/, '0.0').toFloat()  }
     NullObject.metaClass.formatx = { -> delegate.toString().replaceAll(/null/, '0.0').toFloat() }
    Integer.metaClass.formatx = { -> delegate.toString().replaceAll(/null/, '0.0').toFloat() }

    m2= 4.formatx()
    m= "4".formatx()

     println null.formatx()