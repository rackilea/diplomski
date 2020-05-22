package project;
import java.awt.Shape;
import java.util.List;
import project.ERDBUILDER.DrawingBoard.Attribute;
import project.ERDBUILDER.DrawingBoard.Connection;
import project.ERDBUILDER.DrawingBoard.NamedShape;


public class SQL {    

public void display(List<Connection> con) {

    for (int a = 0; a < con.size(); a++) {
                                NamedShape f = con.get(a).getNamedShape1();
                                Attribute g = con.get(a).getNamedShape2();
                                String i = f.getName();
                                String j = g.getName();

                                Shape y = f.getShape();
                                Shape y1 = g.getShape();
                                System.out.println(i + " AND " + j + " are linked");

}



}
}