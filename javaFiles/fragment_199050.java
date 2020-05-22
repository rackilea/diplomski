import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class DockPanel extends Composite {

    private static DockPanelUiBinder uiBinder = GWT
            .create(DockPanelUiBinder.class);

    interface DockPanelUiBinder extends UiBinder<Widget, DockPanel> {
    }

    @UiField Button botao;
    public DockPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        //Botao para mostrar qq coisa
        botao.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                //Aqui coloquei um link, mas depois sera colocado uma accao
                Window.Location.assign("http://www.sapo.pt");   
            }
        });

    }

}