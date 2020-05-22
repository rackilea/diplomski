package de.scrum_master.stackoverflow

import spock.lang.Specification

/**
 * See https://stackoverflow.com/q/48391716/1082681
 * See http://spockframework.org/spock/docs/1.1/all_in_one.html#GroovyMocks
 */
class AnotherClassTest extends Specification {
  def "indirectly use GroovyMock for final method in final class"() {
    given:
    FinalClass finalClass = GroovyMock() {
      finalMethod() >> "mocked"
    }

    expect:
    new AnotherClass().doSomething(finalClass) == "mocked"
  }

  def "indirectly use global GroovySpy for final static method in final class"() {
    given:
    GroovySpy(FinalClass, global: true)
    FinalClass.finalStaticMethod() >> "mocked"

    expect:
    new AnotherClass().doSomethingElse() == "mocked"
  }
}