package injecteermessagesource

import io.micronaut.context.MessageSource
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller('/people')
class PersonController  extends CRUDController<Person> {
    protected PersonController() {
        super(Person)
    }

    @Get('/')
    String index() {
        def context = MessageSource.MessageContext.DEFAULT
        def message = messageSource.getMessage('test', context)
        message.get()
    }
}