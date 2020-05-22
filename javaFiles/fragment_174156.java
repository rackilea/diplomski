package qwerky.sandbox;

import java.util.ArrayList;
import java.util.List;

public class MemLeakTest {

    public static void main(String[] args) throws Exception{

        List<PointlessObject> list = new ArrayList<PointlessObject>();

        while (true) {

            for(int i = 0; i<100000; i++){
                list.add(new PointlessObject());
            }

            Thread.sleep(1000);

            list.clear(); //ArrayList elements remained in memory

            Thread.sleep(1000);
        }
    }

}

class PointlessObject{
    String text;

    PointlessObject(){
        text = "Stuff";
    }
}