import com.qqwing.*;

public class Test {
    public static void main(String[] args){
        QQWing qq = new QQWing();
        qq.generatePuzzle();
        System.out.println(qq.getPuzzleString());
    }
}