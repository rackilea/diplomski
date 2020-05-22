import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShootingGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        final double width = 400 ;
        final double height = 400 ;

        final double targetRadius = 25 ;
        final double projectileRadius = 5 ;

        final double weaponLength = 25 ;

        final double weaponX = width / 2 ;
        final double weaponStartY = height ;
        final double weaponEndY = height - weaponLength ;

        final double targetStartX = targetRadius ;
        final double targetY = targetRadius * 2 ;;

        Pane root = new Pane();
        Circle target = new Circle(targetStartX, targetY, targetRadius, Color.BLUE);
        TranslateTransition targetMotion = new TranslateTransition(Duration.seconds(2), target);
        targetMotion.setByX(350);
        targetMotion.setAutoReverse(true);
        targetMotion.setCycleCount(Animation.INDEFINITE);
        targetMotion.play();

        Line weapon = new Line(weaponX, weaponStartY, weaponX, weaponEndY);
        weapon.setStrokeWidth(5);
        Rotate weaponRotation = new Rotate(0, weaponX, weaponStartY);
        weapon.getTransforms().add(weaponRotation);

        Scene scene = new Scene(root, width, height);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                weaponRotation.setAngle(Math.max(-45, weaponRotation.getAngle() - 2));
            }
            if (e.getCode() == KeyCode.RIGHT) {
                weaponRotation.setAngle(Math.min(45, weaponRotation.getAngle() + 2));
            }
            if (e.getCode() == KeyCode.SPACE) {

                Point2D weaponEnd = weapon.localToParent(weaponX, weaponEndY);

                Circle projectile = new Circle(weaponEnd.getX(), weaponEnd.getY(), projectileRadius);

                TranslateTransition shot = new TranslateTransition(Duration.seconds(1), projectile);
                shot.setByX(Math.tan(Math.toRadians(weaponRotation.getAngle())) * height);
                shot.setByY(-height);
                shot.setOnFinished(event -> root.getChildren().remove(projectile));

                BooleanBinding hit = Bindings.createBooleanBinding(() -> {
                    Point2D targetLocation = target.localToParent(targetStartX, targetY);
                    Point2D projectileLocation = projectile.localToParent(weaponEnd);
                    return (targetLocation.distance(projectileLocation) < targetRadius + projectileRadius) ;
                }, projectile.translateXProperty(), projectile.translateYProperty());

                hit.addListener((obs, wasHit, isNowHit) -> {
                    if (isNowHit) {
                        System.out.println("Hit");
                        root.getChildren().remove(projectile);
                        root.getChildren().remove(target);
                        targetMotion.stop();
                        shot.stop();
                    }
                });

                root.getChildren().add(projectile);
                shot.play();
            }
        });

        root.getChildren().addAll(target, weapon);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}