public class tic_tac_toe extends Application
{
    private static final String X = "X";  // named constants are better than copy-paste
    private static final String O = "O";

    String token = X;

    private void checkForEnd()
    {
    }

    private Button createFieldButton()
    {
        Button b = new Button();
        b.setOnAction(e -> {
            if ("".equals(b.getText()))
            {
                b.setText(token);
                if (X.equals(token))
                    token = O;
                else
                    token = X;
                checkForEnd();
            }
        });
        return b;
    }

    public void start(Stage stage)
    {
        GridPane p = new GridPane();
        p.setAlignment(Pos.TOP_LEFT);
        p.setHgap(10);
        p.setVgap(10);
        Button[][] fieldButtons = new Button[3][];
        for (int y = 0; y < 3; y++)
        {
            fieldButtons[y] = new Button[3];
            for (int x = 0; x < 3; x++)
            {
                fieldButtons[y][x] = createFieldButton();
                p.add(fieldButtons[y][x], x, y);
            }
        }

        Scene s = new Scene(p, 500, 500);
        stage.setScene(s);
        stage.show();
    }   
}