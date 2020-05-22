import java.util.Scanner;
import java.lang.*;

public class Grid
{
// declaring class array named grid
public static char[][] grid = new char[80][30];

// method: main
// purpose: calls getInput and initGrid

public static void main(String[] args)
{
initGrid();
getInput();
}

// method: initGrid
// purpose: initializes the grid with spaces, also acts as the clear command
public static void initGrid()
{
char fill = '1';
for(int i = 0; i < grid.length; i++){
    for(int j = 0; j < grid[0].length; j++){
    grid[i][j] = fill;
    }
}
}

// method: getInput
// purpose: gets the input and sends it to the appropriate method
public static void getInput()
{
char firstCharacter, drawCharacter;
int X1, Y1, X2, Y2;
Scanner in = new Scanner(System.in);
while(in.hasNextLine()){
    firstCharacter = in.next().charAt(0);
    if(firstCharacter == 'p'){
    X1 = in.nextInt();
    Y1 = in.nextInt();
    drawCharacter = in.next().charAt(0);
    in.nextLine();
    plotPoint(X1, Y1, drawCharacter);
    }
    if(firstCharacter == 'l'){
    X1 = in.nextInt();
    Y1 = in.nextInt();
    X2 = in.nextInt();
    Y2 = in.nextInt();
    drawCharacter = '*';
    in.nextLine();
    drawLine(X1, Y1, X2, Y2, drawCharacter);
    }
    if(firstCharacter == 'c'){
    in.nextLine();
    initGrid();
    }
    if(firstCharacter == 'd'){
    in.nextLine();
    printGrid();
    }
    if(firstCharacter == 'q'){
    return;
    }
}

}

// method: plotPoint
// purpose: receives the p command and plots the point with given coordinates and char
public static void plotPoint(int X, int Y, char character)
{
grid[X][Y] = character;
}

// method: drawLine
// purpose: receives the l command and draws a line with given coordinates and char
public static void drawLine(int X1, int Y1, int X2, int Y2, char character)
{
// checks for horizontal line, left to right
if(Y1==Y2 && X1<X2){
    for(int i = 0; i<= Math.abs(X2-X1); i++){ 
    grid[X1+i][Y1] = character;
    }
}

// checking for horizontal line, right to left
if(Y1==Y2 && X1>X2){
    for(int i=02; i<=Math.abs(X2-X1); i++){
    grid[X2+i][Y1] = character;
    }
}

// checking for vertical line, top to bottom
if(X1==X2 && Y1<Y2){
    for(int i = 0; i<=Math.abs(Y1-Y2); i++){
    grid[X1][Y1+i] = character;
    }
}

// checking for vertical line, bottom to top
if(X1==X2 && Y1>Y2){
    for(int i = 0; i<=Math.abs(Y1-Y2); i++){
    grid[X1][Y2+i] = character;
    }
} 

}

// method: printGrid
// purpose: prints the grid to show the picture
public static void printGrid()
{
for(int j = 0; j < grid[0].length; j++){
    for(int i = 0; i <  grid.length; i++){
    System.out.print(grid[i][j]);
    if(i == grid.length-1){
        System.out.println();
    }

    }
}
}
}