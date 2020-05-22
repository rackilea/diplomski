open class ApplicationEvent(source: Any): EventObject(source) {}

interface ApplicationListener<T: ApplicationEvent> {
    fun onApplicationEvent(event: T)
}

// the Spring Data Neo4j version requires a type
class BeforeSaveEvent<T>(source: Any, val entity: T): ApplicationEvent(source) {}

// the Spring data version does not
class BeforeSaveEvent(source: Any): ApplicationEvent(source) {}