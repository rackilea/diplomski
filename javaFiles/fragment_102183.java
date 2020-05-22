package de.scrum_master.stackoverflow

import de.jodamob.kotlin.testrunner.OpenedClasses
import de.jodamob.kotlin.testrunner.OpenedPackages
import de.jodamob.kotlin.testrunner.SpotlinTestRunner
import org.junit.runner.RunWith
import spock.lang.Specification

/**
 * See https://stackoverflow.com/q/48391716/1082681
 * See https://github.com/dpreussler/kotlin-testrunner
 */
@RunWith(SpotlinTestRunner)
@OpenedClasses(FinalClass)
//@OpenedPackages("de.scrum_master.stackoverflow")
class AnotherClassSpotlinRunnerTest extends Specification {
  def "use SpotlinRunner to stub final method in final class"() {
    given:
    FinalClass finalClass = Stub() {
      finalMethod() >> "mocked"
    }

    expect:
    new AnotherClass().doSomething(finalClass) == "mocked"
  }
}