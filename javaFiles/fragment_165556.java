import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String args[]) {
        List<Line> givenLines = new ArrayList<Line>();
        givenLines.add(new Line(3350, 1500, 3200, 1500));
        givenLines.add(new Line(1450, 1750, 1450, 2200));
        givenLines.add(new Line(1450, 2200, 2100, 2200));
        givenLines.add(new Line(2400, 2200, 2550, 2200));
        givenLines.add(new Line(2550, 2200, 2550, 2350));
        givenLines.add(new Line(2550, 2350, 2850, 2350));
        givenLines.add(new Line(2850, 2350, 2850, 2700));
        givenLines.add(new Line(2850, 2700, 3350, 2700));
        givenLines.add(new Line(3650, 2700, 3750, 2700));
        givenLines.add(new Line(3750, 2700, 3750, 2600));
        givenLines.add(new Line(3750, 2600, 5250, 2600));
        givenLines.add(new Line(5250, 2600, 5250, 2350));
        givenLines.add(new Line(5250, 2350, 5000, 2350));
        givenLines.add(new Line(4700, 2350, 4350, 2350));
        givenLines.add(new Line(4350, 2350, 4350, 1600));
        givenLines.add(new Line(4350, 1600, 3650, 1600));
        givenLines.add(new Line(3650, 1600, 3650, 1500));
        givenLines.add(new Line(3200, 1500, 3200, 1750));
        givenLines.add(new Line(3200, 1750, 1450, 1750));

        int linesIndex, usedCounter=0;
        List<List<Line>> listOfConnectedLines = new ArrayList<List<Line>>();

        //The start (first) line, in the list of given lines, to be processed to find the first set of connected lines
        Line startLineforTheNextSetOfConnectedLines=givenLines.get(0);
        startLineforTheNextSetOfConnectedLines.setUsed(true);
        usedCounter = 1;        

        //Process the list of given lines until all the lines have been used to form the connected lines
        while (usedCounter < givenLines.size()) {

            linesIndex = 0;         
            List<Line> connectedLines = new ArrayList<Line>();
            connectedLines.add(linesIndex, startLineforTheNextSetOfConnectedLines);     
            Line nextLine=null;

            //Starting with startLineforTheNextSetOfConnectedLines, the variable lastArrangedLine will hold the next lines qualifying to become the connected line 
            Line lastArrangedLine=startLineforTheNextSetOfConnectedLines;

            //Create the list of connected lines starting with startLineforTheNextSetOfConnectedLines
            for (int i = 0; i < givenLines.size(); i++) {
                for (int j = 0; j < givenLines.size(); j++) {
                    nextLine=givenLines.get(j);
                    if (!nextLine.isUsed() && lastArrangedLine.getX2() == nextLine.getX1()
                            && lastArrangedLine.getY2() == nextLine.getY1()) {
                        nextLine.setUsed(true);
                        usedCounter++;
                        connectedLines.add(++linesIndex, nextLine);
                        lastArrangedLine = nextLine;
                        break;
                    }
                }
            }

            //Add the list of connected lines (found from the above nested for loops) to the list of connected lines
            listOfConnectedLines.add(connectedLines);

            //Find the start (first) line for the next set of connected lines
            for (int i = 0; i < givenLines.size(); i++) {
                if(!givenLines.get(i).isUsed()) {
                    startLineforTheNextSetOfConnectedLines=givenLines.get(i);
                    startLineforTheNextSetOfConnectedLines.setUsed(true);
                    usedCounter++;                  
                    break;
                }
            }
        }

        //Display the lists of connected lines
        for(List<Line> connectedLines:listOfConnectedLines)
            System.out.println(connectedLines);
    }
}