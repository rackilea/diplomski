import spock.lang.Specification

class LolSpec extends Specification {

    def 'lol'() {
        given:
        def repository = Mock(Repository)
        def service = new Service(repository: repository)

        when:
        service.save(a)

        then:
        1 * repository.save({ it ->
            it.value == b
        })

        where:
        a | b
        1 | "one"
        2 | "two"
    }

}

class Repository {
    def save(Entity e) {

    }
}

class Service {
    Repository repository

    def save(Integer value) {
        Entity e
        if (value == 1) {
            e = new Entity(value: "one")
        } else {
            e = new Entity(value: "two")
        }
        repository.save(e)
    }
}

class Entity {
    String value
}