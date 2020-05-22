[~/tests/java/snake2]$ pwd
/home/stephenp/tests/java/snake2

[~/tests/java/snake2]$ cat GameBoard.java

package snake2;

class GameBoard {

    private static int instanceCount = 0;

    GameBoard() {
        GameBoard.instanceCount++;
    }

    void howMany() {
        System.out.println(instanceCount + " GameBoards have been created.");
    }
}

[~/tests/java/snake2]$ cat SnakeGame.java

package snake2;

public class SnakeGame {

    private GameBoard board = null;

    public SnakeGame() {
        this.board = new GameBoard();
    }

    void report(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.report("I exist");
        game.board.howMany();
    }
}


[~/tests/java/snake2]$ ls -1
GameBoard.java
SnakeGame.java

[~/tests/java/snake2]$ javac *.java

[~/tests/java/snake2]$ ls -1
GameBoard.class
GameBoard.java
SnakeGame.class
SnakeGame.java

[~/tests/java/snake2]$ java SnakeGame
Exception in thread "main" java.lang.NoClassDefFoundError: SnakeGame (wrong name: snake2/SnakeGame)
        at java.lang.ClassLoader.defineClass1(Native Method)
        at java.lang.ClassLoader.defineClass(ClassLoader.java:620)
        at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:124)
        at java.net.URLClassLoader.defineClass(URLClassLoader.java:260)
        at java.net.URLClassLoader.access$000(URLClassLoader.java:56)
        at java.net.URLClassLoader$1.run(URLClassLoader.java:195)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(URLClassLoader.java:188)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:306)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:276)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:251)
        at java.lang.ClassLoader.loadClassInternal(ClassLoader.java:319)

[~/tests/java/snake2]$ java snake2.SnakeGame
Exception in thread "main" java.lang.NoClassDefFoundError: snake2/SnakeGame
Caused by: java.lang.ClassNotFoundException: snake2.SnakeGame
        at java.net.URLClassLoader$1.run(URLClassLoader.java:200)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(URLClassLoader.java:188)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:306)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:276)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:251)
        at java.lang.ClassLoader.loadClassInternal(ClassLoader.java:319)

[~/tests/java/snake2]$ java -cp .. snake2.SnakeGame
I exist
1 GameBoards have been created.