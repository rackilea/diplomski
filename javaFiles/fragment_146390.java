import java.util.concurrent.TimeUnit;

    import io.reactivex.Observable;
    import io.reactivex.schedulers.Schedulers;
    import io.reactivex.subjects.PublishSubject;
    import javafx.application.Application;
    import javafx.application.Platform;
    import javafx.scene.Scene;
    import javafx.scene.control.TextField;
    import javafx.scene.input.InputEvent;
    import javafx.stage.Stage;
    import javafx.stage.WindowEvent;

    public class CloseAfterApp extends Application {


        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {
            Scene scene = new Scene(new TextField());

            PublishSubject<InputEvent> sceneEventPublishable = PublishSubject.create();
            PublishSubject<WindowEvent> windowEventPublishable = PublishSubject.create();

            scene.addEventFilter(InputEvent.ANY, sceneEventPublishable::onNext);
            stage.addEventFilter(WindowEvent.ANY, windowEventPublishable::onNext);

            Observable.merge(sceneEventPublishable, windowEventPublishable)
            .switchMap(event -> Observable.just(event).delay(4, TimeUnit.SECONDS, Schedulers.single()))
            .subscribe(event -> Platform.exit());

            stage.setScene(scene);
            stage.show();
        }
    }