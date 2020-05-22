import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

public class TabSelectionComponent extends VerticalLayout {
    public TabSelectionComponent() {
        // tab contents
        Button aButton = new Button("A");
        Button bButton = new Button("B");

        // tabs and tab sheet
        TabSheet tabs = new TabSheet();
        TabSheet.Tab aTab = tabs.addTab(aButton, "A");
        TabSheet.Tab bTab = tabs.addTab(bButton, "B");

        // checkboxes for selection visualization
        CheckBox byTabInstance = new CheckBox("Check by tab instance");
        byTabInstance.setEnabled(false);
        CheckBox byTabContent = new CheckBox("Check by tab content");
        byTabContent.setEnabled(false);

        tabs.addSelectedTabChangeListener(event -> {
            // the selected tab matches the expected one
            byTabInstance.setValue(tabs.getTab(tabs.getSelectedTab()) == aTab);

            // the selected content matches the expected one 
            byTabContent.setValue(tabs.getSelectedTab() == aButton);
        });

        // add components to the UI
        addComponents(tabs, byTabContent, byTabInstance);
    }
}