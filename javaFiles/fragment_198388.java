import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

enum Role { father, son, mother, daughter, brother, sister }

class RoleManager {
    private final Map<Node, List<Role>> nodeRoles = new HashMap<>();
    private ObservableList<Role> activeRoles;

    public final ListChangeListener<Role> ACTIVE_ROLE_LISTENER = new ListChangeListener<Role>() {
        @Override
        public void onChanged(Change<? extends Role> c) {
            showActiveNodes();
        }
    };

    public void setActiveRoles(ObservableList<Role> activeRoles) {
        if (this.activeRoles != null) {
            this.activeRoles.removeListener(ACTIVE_ROLE_LISTENER);
        }
        this.activeRoles = activeRoles;
        this.activeRoles.addListener(ACTIVE_ROLE_LISTENER);
    }

    public void showActiveNodes() {
        for (Node node : nodeRoles.keySet()) {
            node.setVisible(isActive(node));
        }
    }

    public void assignRole(Node node, Role... roles) {
        nodeRoles.put(node, Arrays.asList(roles));
    }

    private boolean isActive(Node node) {
        if (activeRoles == null) {
            return false;
        }

        for (Role role: nodeRoles.get(node)) {
            if (activeRoles.contains(role)) {
                return true;
            }
        }

        return false;
    }
}

public class RoleVisibility extends Application {

    private RoleManager roleManager = new RoleManager();

    @Override
    public void start(Stage stage) {
        VBox layout = new VBox(10);
        layout.getChildren().setAll(
            getRoleChooser(),
            createContent()
        );
        layout.setStyle("-fx-padding: 10px; -fx-background-color: cornsilk;");

        roleManager.showActiveNodes();

        stage.setTitle("Role Selector");
        stage.setScene(new Scene(layout));
        stage.show();
    }

    private Node getRoleChooser() {
        ObservableList<Role> activeRoles = FXCollections.observableArrayList();

        VBox roleChooser = new VBox(10);
        for (final Role role: Role.values()) {
            CheckBox checkBox = new CheckBox(role.toString());
            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean wasSelected, Boolean isSelected) {
                    if (isSelected) {
                        activeRoles.add(role);
                    } else {
                        activeRoles.remove(role);
                    }
                }
            });

            roleChooser.getChildren().add(checkBox);
        }

        roleManager.setActiveRoles(
            activeRoles
        );

        return roleChooser;
    }

    private Pane createContent() {
        HBox content = new HBox(10);

        // icon license:
        //License: Free for non-commercial use.
        //Commercial usage: Not allowed
        //The products or characters depicted in these icons are © by Lucasfilm Ltd.

        content.getChildren().addAll(
            createLabel("Darth Vader",    "Vader-03-icon.png",          Role.father),
            createLabel("Queen Amidala",  "Padme-Amidala-icon.png",     Role.mother),
            createLabel("Luke Skywalker", "Luke-Skywalker-01-icon.png", Role.brother,  Role.son),
            createLabel("Princess Leia",  "Leia-icon.png",              Role.daughter, Role.sister)
        );

        return content;
    }

    private Label createLabel(String text, String graphic, Role... roles) {
        Label label = new Label(
            text,
            new ImageView(
                new Image(
                    "http://icons.iconarchive.com/icons/jonathan-rey/star-wars-characters/128/" + graphic
                )
            )
        );

        label.setContentDisplay(ContentDisplay.TOP);

        roleManager.assignRole(label, roles);

        return label;
    }


    public static void main(String[] args) {
        launch(args);
    }
}