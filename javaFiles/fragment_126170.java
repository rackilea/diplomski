import java.util.Random;

public class Demineur 
{
    // Here come CONSTANTS
    public static final int     MAX_MINES = 30;
    public static final boolean MINE      = true;

    // Let's have a field 12x12 size
    public static final int LONGEUR   = 12;
    public static final int LARGEUR   = 12;

    // each field contains number of mines it has access to
    public static int     champDeMine[][]  = new int[LONGEUR][LARGEUR];

    // each field can contain mine or be empty
    public static boolean champDeMines[][] = new boolean[LONGEUR][LARGEUR];

    public static void minesweeper() 
    {
        Random  random  = new Random();
        int     mine           ;

        System.out.println("Ajustement du nombre de mines en cours...");
        int     nbMines = random.nextInt(MAX_MINES);

        /**
         * Let's plant mines. :-E
         * Unoptimal but will suffice for demonstration purpose.
         */
        int minesLeftToPlant = nbMines;
        int skip             = 0;
        boolean planted      = false;
        while (minesLeftToPlant > 0)
        {
            skip    = random.nextInt(LONGEUR*LARGEUR);
            planted = false;
            while (!planted && minesLeftToPlant > 0 && skip > 0)
            {
                for (int y = 0; !planted && minesLeftToPlant > 0 && y < LONGEUR; y++)
                {
                    for (int x = 0; !planted && minesLeftToPlant > 0 && x < LARGEUR; x++)
                    {
                        if (   !MINE == champDeMines[y][x] 
                            && 0 == skip)
                        {
                            champDeMines[y][x] = MINE;
                            minesLeftToPlant--;
                            planted = true;
                        }
                        else
                        {
                            skip--;
                        }
                    }
                }
            }
        }
        System.out.println("Chargement des "+ nbMines +" mines OK.");
    }

    public static void calculeProximite()
    {
        int row ; //row index for prescence of 0, same value as longueur
        int col ; //column index for presence of 0, same value as largeur
        int mine;

        //Check for each field it's neighbors and calculate which of them are mines
        for (row = 0; row < LONGEUR; row++)
        {
            for (col = 0; col < LARGEUR; col++)
            {
                champDeMine[row][col] = numberOfMines(row,col);
            }
        }

    }

    public static void printChampDeMine()
    {
        for (int row = 0; row < LONGEUR; row++)
        {
            for (int col = 0; col < LARGEUR; col++)
            {
                System.out.print("'" + champDeMine[row][col] + "' ");
            }
            System.out.println();
        }
    }

    public static void printChampDemines()
    {
        for (int row = 0; row < LONGEUR; row++)
        {
            for (int col = 0; col < LARGEUR; col++)
            {
                System.out.print("'" + (champDeMines[row][col] ? "m" : "e") + "' ");
            }
            System.out.println();
        }
    }

    public static int numberOfMines(int row, int col)
    {
        return add(hasMine(row    , col + 1))
            +  add(hasMine(row - 1, col + 1))
            +  add(hasMine(row - 1, col    ))
            +  add(hasMine(row - 1, col - 1))
            +  add(hasMine(row    , col - 1))
            +  add(hasMine(row + 1, col - 1))
            +  add(hasMine(row + 1, col    ))
            +  add(hasMine(row + 1, col + 1));
    }

    public static boolean hasMine(int row, int col)
    {
        return row >= 0 && col >= 0 && row < LONGEUR && col < LARGEUR 
            && isMine(champDeMines[row][col]);
    }

    public static boolean isMine(boolean x)
    {
        return MINE == x;
    }

    public static int add(boolean c)
    {
        return c ? 1 : 0;
    }

    public static void main(String[] args)
    {
        minesweeper();
        System.out.println("Champ de mines");
        printChampDemines();
        System.out.println("Champ de mine");
        calculeProximite();
        printChampDeMine();
    }
}