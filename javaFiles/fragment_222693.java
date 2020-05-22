module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.fontawesomefx.fontawesome;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}