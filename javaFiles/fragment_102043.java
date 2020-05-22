import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

            }
        };
        SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty();
        System.out.println(hasListener(simpleBooleanProperty,changeListener));
        simpleBooleanProperty.addListener(changeListener);
        System.out.println(hasListener(simpleBooleanProperty,changeListener));
        simpleBooleanProperty.removeListener(changeListener);
        System.out.println(hasListener(simpleBooleanProperty,changeListener));
    }

    public static boolean hasListener(ObservableValue observableValue, ChangeListener listener){

        Object value;
        ChangeListener[] list=null;
        ChangeListener changeListener=null;
        Field field = null;

        try {
            if(observableValue instanceof SimpleFloatProperty){
                field = FloatPropertyBase.class.getDeclaredField("helper");
            }
            else if(observableValue instanceof SimpleBooleanProperty){
                field = BooleanPropertyBase.class.getDeclaredField("helper");
            }
            else if(observableValue instanceof SimpleIntegerProperty){
                field = IntegerPropertyBase.class.getDeclaredField("helper");
            }
            field.setAccessible(true);
            value = field.get(observableValue);
            try {
                if(value==null){
                    return false;
                }
                field = value.getClass().getDeclaredField("listener");
                field.setAccessible(true);
                changeListener =(ChangeListener)field.get(value);
            }catch (NoSuchFieldException e) {
                //e.printStackTrace();
            }
            try {
                field = value.getClass().getDeclaredField("changeListeners");
                field.setAccessible(true);
                list =(ChangeListener[])field.get(value);
            }catch (NoSuchFieldException e) {
                //e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(list!=null){
            for (ChangeListener c:list) {
                if(c==listener){
                    return true;
                }
            }
            return false;
        }
        else {
            return changeListener==listener;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}