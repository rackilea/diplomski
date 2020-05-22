BufferedReader input = new BufferedReader(new FileReader("maze.txt"));

//Read the first two lines of the text file and determine the x and y length of the 2d array
int mazeWidth = Integer.parseInt(input.readLine());  //A.K.A number of columns
int mazeHeight= Integer.parseInt(input.readLine());  //A.K.A number of rows

//          ranges: [0...3][0...5] in our example
mazeArray = new char[mazeWidth][mazeHeight];

char [] line;

//Add each line of input to mazeArray
for (int y = 0; y < mazeHeight; y++) 
{
    line = (input.readLine()).toCharArray();

    if ( line.length != mazeWidth )
    {
        System.err.println("Error for line " + y + ". Has incorrect number of characters (" + line.length + " should be " + mazeWidth + ").");
    }
    else {
        System.out.print(y + " : ");
        System.out.println(java.util.Arrays.toString(line));
        mazeArray[y] = line;
    }
}