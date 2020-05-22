// run with `spring run vaadin.groovy`
@Grapes([
@Grab('org.vaadin.spring:spring-boot-vaadin:0.0.5.RELEASE'),
@Grab('com.vaadin:vaadin-server:7.5.9'),
@Grab('com.vaadin:vaadin-client-compiled:7.5.9'),
@Grab('com.vaadin:vaadin-themes:7.5.9'),
])
import org.vaadin.spring.annotation.VaadinUI
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.*
import com.vaadin.annotations.*
import com.vaadin.server.Sizeable

@VaadinUI
@Theme("valo")
class MyUI extends UI {
        protected void init(VaadinRequest request) {
                setContent(new HorizontalSplitPanel(new Label("A"), new Label("B")).with{
                        setSplitPosition(40, Sizeable.Unit.PIXELS, true /*!*/)
                        it
                })
        }
}