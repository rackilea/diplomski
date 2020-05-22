package fr.imag.ufrima.tat.tp6.aspects;

import java.util.Collection;
import java.util.Set;

import fr.imag.ufrima.tat.tp6.aspects.monitor.MonitorHashCode;

/**
 * Techniques Avancées de Test
 * 
 * @author Rodmar CONDE
 *
 * Instrumentator for validation of HashSet classes.
 * 
 * Secures the usage of HashSet that include Collections in preventing 
 * more elements to be added to the collections once they are added. 
 * 
 * Monitor code is provided in a separate class: MonitorHashCode.
 */
public aspect InstrumentationHashCode {

    private MonitorHashCode monitorHashCode;

    public InstrumentationHashCode() {
        monitorHashCode = new MonitorHashCode();
    }

    pointcut addElementsToHashCodeSet() : call (* Set.add(..));

    declare warning: addElementsToHashCodeSet(): "pointcut: addElementsToHashCode()";

    before(Collection c): addElementsToHashCodeSet() && args(c) { 
        monitorHashCode.addElementsToHashCode(c);                   
    }

    pointcut addElementsToCollection() : call (* Collection.add(..));

    declare warning: addElementsToCollection(): "pointcut: addElementsToCollection()";

    after(String s): addElementsToCollection() && args(s) {
        monitorHashCode.addElementsToCollection(thisJoinPoint.getTarget());     
    }

}