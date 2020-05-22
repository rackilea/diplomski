import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javafx.geometry.Point2D;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author jpereda
 */
public class LinearPath {

    private final Path originalPath;

    public LinearPath(Path path){
        this.originalPath=path;
    }

    public Path generateLinePath(){
        /*
        Generate a list of points interpolating the original path
        */
        originalPath.getElements().forEach(this::getPoints);

        /*
        Create a path only with MoveTo,LineTo
        */
        Path path = new Path(new MoveTo(list.get(0).getX(),list.get(0).getY()));
        list.stream().skip(1).forEach(p->path.getElements().add(new LineTo(p.getX(),p.getY())));
        path.getElements().add(new ClosePath());
        return path;
    }

    private Point2D p0;
    private List<Point2D> list;
    private final int POINTS_CURVE=5;

    private void getPoints(PathElement elem){
        if(elem instanceof MoveTo){
            list=new ArrayList<>();
            p0=new Point2D(((MoveTo)elem).getX(),((MoveTo)elem).getY());
            list.add(p0);
        } else if(elem instanceof LineTo){
            list.add(new Point2D(((LineTo)elem).getX(),((LineTo)elem).getY()));
        } else if(elem instanceof CubicCurveTo){
            Point2D ini = (list.size()>0?list.get(list.size()-1):p0);
            IntStream.rangeClosed(1, POINTS_CURVE).forEach(i->list.add(evalCubicBezier((CubicCurveTo)elem, ini, ((double)i)/POINTS_CURVE)));
        } else if(elem instanceof QuadCurveTo){
            Point2D ini = (list.size()>0?list.get(list.size()-1):p0);
            IntStream.rangeClosed(1, POINTS_CURVE).forEach(i->list.add(evalQuadBezier((QuadCurveTo)elem, ini, ((double)i)/POINTS_CURVE)));
        } else if(elem instanceof ClosePath){
            list.add(p0);
        } 
    }

    private Point2D evalCubicBezier(CubicCurveTo c, Point2D ini, double t){
        Point2D p=new Point2D(Math.pow(1-t,3)*ini.getX()+
                3*t*Math.pow(1-t,2)*c.getControlX1()+
                3*(1-t)*t*t*c.getControlX2()+
                Math.pow(t, 3)*c.getX(),
                Math.pow(1-t,3)*ini.getY()+
                3*t*Math.pow(1-t, 2)*c.getControlY1()+
                3*(1-t)*t*t*c.getControlY2()+
                Math.pow(t, 3)*c.getY());
        return p;
    }

    private Point2D evalQuadBezier(QuadCurveTo c, Point2D ini, double t){
        Point2D p=new Point2D(Math.pow(1-t,2)*ini.getX()+
                2*(1-t)*t*c.getControlX()+
                Math.pow(t, 2)*c.getX(),
                Math.pow(1-t,2)*ini.getY()+
                2*(1-t)*t*c.getControlY()+
                Math.pow(t, 2)*c.getY());
        return p;
    }
}