import spock.lang.Specification

class LolSpec extends Specification {

    def 'whatever'() {
        given:
        def prefixer = new Prefixer()
        def issue = Mock(Issue) {
            getKey() >> '1234'
        }

        when:
        def withPrefix = prefixer.returnIssueKeyWithPrefix(issue)

        then:
        withPrefix == 'prefix1234'
    }
}

class Issue {
    String getKey() {
        throw new UnsupportedOperationException('No!')
    }
}

class Prefixer {
    String returnIssueKeyWithPrefix(Issue issue) {
        return "prefix${issue.key}"
    }
}