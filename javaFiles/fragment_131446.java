<BorderPane xmlns="http://javafx.com/javafx/8.0.60" xmlns:fx="http://javafx.com/fxml/1" fx:controller="fxml.ReplaceController">
    <center>
        <StackPane fx:id="stackConsole">
            <children>
                <!-- use multiply blend mode to demonstrate other children are not present
                     (result would be black otherwise) -->
                <Region fx:id="r0" blendMode="MULTIPLY" prefHeight="200.0" prefWidth="200.0" style="-fx-background-color: red;" />
                <fx:define>
                    <Region fx:id="r1" blendMode="MULTIPLY" prefHeight="200.0" prefWidth="200.0" style="-fx-background-color: blue;" />
                    <Region fx:id="r2" blendMode="MULTIPLY" prefHeight="200.0" prefWidth="200.0" style="-fx-background-color: green;" />
                </fx:define>
            </children>
        </StackPane>
    </center>
    <left>
        <VBox prefHeight="200.0" spacing="10.0" BorderPane.alignment="CENTER">
            <children>
                <Button mnemonicParsing="false" text="1" onAction="#btn0"  />
                <Button mnemonicParsing="false" text="2" onAction="#btn1" />
                <Button mnemonicParsing="false" text="3" onAction="#btn2" />
            </children>
            <padding>
                <Insets bottom="10.0" left="10.0" right="10.0" top="10.0" />
            </padding>
        </VBox>
    </left>
</BorderPane>