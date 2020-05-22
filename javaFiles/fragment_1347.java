package IO;

    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.util.List;

    public class ThirtyRead {

        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
            // TODO Auto-generated method stub
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
            // Read in the same order they were written:
            @SuppressWarnings("unchecked")
            List<Class<? extends Shape>> shapeTypes2 = (List<Class<? extends Shape>>)in.readObject();
            Line.deserializeStaticState(in);

            @SuppressWarnings("unchecked")
            List<Shape> shapes2 = (List<Shape>)in.readObject();
            System.out.println(shapes2);

        }

    }
// output

    [class IO.Circlecolor[1] xPos[58] yPos[55] dim[93]
    , class IO.Squarecolor[0] xPos[61] yPos[61] dim[29]
    , class IO.Linecolor[3] xPos[68] yPos[0] dim[22]
    , class IO.Circlecolor[1] xPos[7] yPos[88] dim[28]
    , class IO.Squarecolor[0] xPos[51] yPos[89] dim[9]
    , class IO.Linecolor[3] xPos[78] yPos[98] dim[61]
    , class IO.Circlecolor[1] xPos[20] yPos[58] dim[16]
    , class IO.Squarecolor[0] xPos[40] yPos[11] dim[22]
    , class IO.Linecolor[3] xPos[4] yPos[83] dim[6]
    , class IO.Circlecolor[1] xPos[75] yPos[10] dim[42]
    ]