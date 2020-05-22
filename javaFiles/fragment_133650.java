public class Menu extends JFrame {

    Menu() {
        //How can I call myMainClass setMenu method from here?
        //myMainClass.setMenu("secondMenu");
        //myMainClassObject.setMenu("secondMenu");
    }

    Menu(MyMainClass main) {
        main.setMenu("secondMenu");
    }
}