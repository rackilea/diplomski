import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ConsumeJSON extends Application {

    private ObservableList<PeopleOnSO> listOfPeople;
    private static final String JSON_URL = "https://api.myjson.com/bins/3jwmh";
    private static final String IMAGE_URL = "http://www.fontspring.com/presentation_20150512/images/ajax_loader_blue_512.gif";
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private Image loadImage;

    @Override
    public void start(Stage stage) throws Exception {

        loadImage = new Image(IMAGE_URL);
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        Button button = new Button("Fill GridPane");

        root.getChildren().addAll(button);


        button.setOnAction(e -> {
            // Display loading image
            ImageView loading = new ImageView(loadImage);
            loading.setFitWidth(60);
            loading.setFitHeight(60);
            root.getChildren().add(loading);
            executorService.submit(fetchList);
        });


        fetchList.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                listOfPeople = FXCollections.observableArrayList(fetchList.getValue());
                GridPane gridPane = createGridPane(listOfPeople);
                //Remove Loading Image and add GridPane
                root.getChildren().remove(1);
                VBox.setVgrow(gridPane, Priority.ALWAYS);
                root.getChildren().add(gridPane);
                stage.sizeToScene();
            }
        });

        ScrollPane scrollPane = new ScrollPane(root);
        Scene scene = new Scene(scrollPane, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Load Data from JSON");
        stage.show();

        stage.setOnCloseRequest(e -> {
            executorService.shutdown();
        });
    }

    public GridPane createGridPane(ObservableList<PeopleOnSO> listOfPeople){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(20));
        gridPane.setMinHeight(500);
        gridPane.setMaxWidth(500);

        //Create headings
        Label nameHeading = new Label("Name");
        nameHeading.setStyle("-fx-font-weight: bold");
        Label likeHeading = new Label("Likes");
        likeHeading.setStyle("-fx-font-weight: bold");
        Label imageHeading = new Label("Image");
        imageHeading.setStyle("-fx-font-weight: bold");

        gridPane.add(nameHeading, 0, 0);
        gridPane.add(likeHeading, 1, 0);
        gridPane.add(imageHeading, 2, 0);

        // Aligning at center
        alignElements(nameHeading, likeHeading, imageHeading);

        // Setting Constraints
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(150);
            // column.setPercentWidth(80);
            gridPane.getColumnConstraints().add(column);
        }

        for (int i = 0; i < listOfPeople.size(); i++) {

            PeopleOnSO people = listOfPeople.get(i);
            Label nameLabel = new Label(people.getName());
            Label likeLabel = new Label(people.getLike());
            ImageView imageView = new ImageView(loadImage);
            imageView.setFitHeight(60);
            imageView.setFitWidth(60);

            //Thread for loading images later
            FetchImage fetchImage = new FetchImage(people.getImageUrl());
            fetchImage.setOnSucceeded(worker -> {
                imageView.setImage((Image) fetchImage.getValue());
            });

            executorService.submit(fetchImage);

            // Adding to GridPane and necessary configuration
            gridPane.add(nameLabel, 0, i + 1);
            gridPane.add(likeLabel, 1, i + 1);
            gridPane.add(imageView, 2, i + 1);

            //Aligning at center
            alignElements(nameLabel, likeLabel, imageView);

            gridPane.getRowConstraints().add(new RowConstraints(80));
        }
        return gridPane;
    }

    /**
     * Align elements at the center
     * @param nodes
     */
    private void alignElements(Node ... nodes ) {
        for(Node node : nodes) {
            GridPane.setHalignment(node, HPos.CENTER);
            GridPane.setValignment(node, VPos.CENTER);
        }
    }

    /**
     * Task to fetch details from JSONURL
     * @param <V>
     */
    private Task<List<PeopleOnSO>> fetchList = new Task() {
        @Override
        protected List<PeopleOnSO> call() throws Exception {
            List<PeopleOnSO> list = null;
            try {
                Gson gson = new Gson();
                list = new Gson().fromJson(readUrl(JSON_URL), new TypeToken<List<PeopleOnSO>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
    };

    /**
     * Task to fetch images for individual ImageViews
     * @param <V>
     */
    private class FetchImage<V> extends Task<Image> {

        private String imageUrl;

        public FetchImage(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        protected Image call() throws Exception {
            Image image = new Image(imageUrl);
            return image;
        }

    }

    /**
     * Read the URL and return the json data
     * @param urlString
     * @return
     * @throws Exception
     */
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private class PeopleOnSO {

        private final String name;
        private final String like;
        private final String imageUrl;

        public PeopleOnSO(String name, String like, String imageUrl){
            this.name = new String(name);
            this.like = new String(like);
            this.imageUrl = new String(imageUrl);
        }

        public String getName() {
            return name;
        }

        public String getLike() {
            return like;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}