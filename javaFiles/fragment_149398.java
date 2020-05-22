public class UserInterface extends Application {
    Button btn_js;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        WebView myWebView = new WebView();

        myWebView.getEngine().loadContent("<html>\n" 
                        + " <script>function printArray(arr) {" 
                        + "for (i = 0; i < arr.length; i++) {"
                        + " window.alert(arr[i]);" 
                        + "}"
                        + "} </script> " 
                        + "    </body>\n" 
                        + "</html>");

        List<String> arr = new ArrayList<String>();
        arr.add("Dog");
        arr.add("Cat");

        btn_js = new Button("fire js");
        btn_js.setOnAction(e -> myWebView.getEngine().executeScript("printArray(" + transformToJavascriptArray(arr) + ")"));

        myWebView.getEngine().setOnAlert(event -> System.out.println("JS alert: " + event.getData()));

        VBox root = new VBox();
        root.getChildren().addAll(myWebView, btn_js);
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    private String transformToJavascriptArray(List<String> arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for (String str : arr)
            sb.append("\"").append(str).append("\"").append(", ");

        if (sb.length() > 1)
            sb.replace(sb.length() - 2, sb.length(), "");

        sb.append("]");

        return sb.toString();
    }
}