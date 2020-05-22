package de.scrum_master.aspect;

import de.scrum_master.app.Marker;
import de.scrum_master.app.MyInterface;

/**
 * It is a known JVM limitation that annotations are never inherited from interface
 * to implementing class or from method to overriding method, see explanation in
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Inherited.html">JDK API</a>.
 * <p>
 * Here is a little AspectJ trick which does it manually.
 *
 */
public aspect MarkerAnnotationInheritor {
  // Implementing classes should inherit marker annotation
  declare @type: MyInterface+ : @Marker;
  // Overriding methods 'two' should inherit marker annotation
  declare @method : void MyInterface+.two() : @Marker;
}