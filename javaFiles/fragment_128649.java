package work.basil.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route ( "" )
//@PWA ( name = "Project Base for Vaadin", shortName = "Project Base" )
public class MainView extends VerticalLayout
{
    private Label label;
    private Button button;

    public MainView ( )
    {
        // Widgets
        this.label = new Label( "User: ?" );
        this.button = new Button(
                "Get user" ,
                event -> {
                    Notification.show( "Getting user." );
                    String userName = App.INSTANCE.provideDatabase().getFirstUserName();
                    this.label.setText( "User: " + userName );
                }
        );
        add( button );

        // Arrange
        this.add( label , button );
    }
}