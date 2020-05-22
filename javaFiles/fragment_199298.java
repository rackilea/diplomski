public abstract class UI<T extends AbstractLayout & MainPage> {
    public abstract T getMainPage();
}

public class MyUI extends UI<MyPage> { // Compiler error: Bound mismatch

    @Override
    public MyPage getMainPage() {
        return new MyPage();
    }

}

public class MyPage implements MainPage {}

public class AbstractLayout {}

public interface MainPage {}