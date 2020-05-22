import java.util.Random;

public class ShellingSegregationModel
{
    public static final int EMPTY = 0;
    public static final int BLUE  = 1;
    public static final int RED   = 2;

    // number of elements for random
    public static final int ELEMENTS = 3;

    public static final double THRESHOLD = 0.15;        

    //size of the field
    public int size;

    int[][] field;
    // temporary field for the iteration
    int[][] temporary;

    public int iteration;

    public ShellingSegregationModel(int size)
    {    
        Random random = new Random();
        this.size = size;
        field     = new int[size][size];
        for (int y = 0; y < size; y++)
        {
            for (int x = 0; x < size; x++)
            {
                field[y][x] = random.nextInt(ELEMENTS);
            }
        }
    }

    public int getSize()
    {
        return size;
    }

    public void setField(int[][] field)
    {
        this.field = field;
    }

    public int[][] getField()
    {
        return field;
    }

    public void setTemporary(int[][] temporary)
    {
        this.temporary = temporary;
    }

    public int[][] getTemporary()
    {
        return temporary;
    }

    public int getIteration()
    {
        return iteration;
    }

    public void setIteration(int iteration)
    {
        this.iteration = iteration;
    }

    public double getThreshold()
    {
        return THRESHOLD;   
    }

    //how many neighbors needed for threshold
    public double getCalculatedThreshold()
    {
        return getThreshold()*8;//8 is the neighbors count total possible
    }

    public static String getSymbolFor(int x)
    {
        String s = "";
        switch (x)
        {            
            case BLUE:
                s = "x";
                break;
            case RED :
                s = "o";
                break;
            case EMPTY:
            default:
                s = " ";                
        }
        return s;
    }

    public boolean isEmpty(int x, int y)
    {
        return get(x,y) == EMPTY;
    }

    /**
     * Prints field
     */
    public void print(String message)
    {
        System.out.println(message);
        for (int y = 0; y < getSize(); y++)
        {          
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < getSize(); x++)
            {                
                row.append("'").append(getSymbolFor(get(x,y))).append("' ");
            }
            System.out.println(row.toString());
        }
    }

    public void printSameNeighorsCount(String message)
    {
        System.out.println(message);
        for (int y = 0; y < getSize(); y++)
        {          
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < getSize(); x++)
            {                
                row.append("'").append(sameNeighbors(x, y)).append("' ");
            }
            System.out.println(row.toString());
        }
    }

    public int get(int x, int y)
    {
        return getField()[y][x];
    }

    private int add(boolean c)
    {
        return c ? 1 : 0;
    }

    public int sameNeighbors(int x, int y)
    {
        return isEmpty(x,y) ? 0 : 
                  add(isSame(get(x,y),x  ,y-1)) 
                + add(isSame(get(x,y),x-1,y-1))
                + add(isSame(get(x,y),x-1,y  ))
                + add(isSame(get(x,y),x-1,y+1))
                + add(isSame(get(x,y),x  ,y+1))
                + add(isSame(get(x,y),x+1,y+1))
                + add(isSame(get(x,y),x+1,y  ))
                + add(isSame(get(x,y),x+1,y-1));
    }    

    private static void copyArray(int[][] src, int[][] dest)
    {        
        for (int i = 0; i < src.length; i++)
        {
            dest[i] = new int[src[i].length];
            System.arraycopy(src[i], 0, dest[i], 0, src[i].length);            
        }                
    }
    private void duplicateToTemporary()
    {
        setTemporary(new int[getField().length][]);
        copyArray(getField(),getTemporary());
    }

    //
    private void assignFromTemporary()
    {
        setField(new int[getField().length][]);
        copyArray(getTemporary(), getField());
    }

    public void iterate(int iterations)
    {        
        for (int i = 0; i < iterations; i++)          
        {
            duplicateToTemporary();
            for (int y = 0; y < getSize(); y++)
            {
                for (int x = 0; x < getSize(); x++)
                {
                    if (!isHappy(x,y))
                    {
                        swap(x,y);
                    }
                }
            }
            assignFromTemporary();
        }
        setIteration(getIteration()+iterations);
    }

    //Swaps with empty random from temporary
    public void swap(int i, int j)
    {
        Random random    = new Random();
        boolean swapped  = false;
        //skip a random number of empty
        int     skip     = random.nextInt(100);
        while (!swapped)
        {
            for (int y = 0; !swapped && y < getSize(); y++)
            {
                for (int x = 0; !swapped && x < getSize(); x++)
                {
                    if (getTemporary()[y][x] == EMPTY && 0 >= --skip)
                    {                        
                        getTemporary()[y][x] = getTemporary()[j][i];
                        getTemporary()[j][i] = EMPTY   ;
                        swapped = true;
                    }
                }
            }
        }
    }

    public boolean isHappy(int x, int y)
    {
        return getCalculatedThreshold() < sameNeighbors(x, y);        
    }

    public boolean isSame(int me, int x, int y)
    {
        return 
                //check bounds
                x >= 0 && y >= 0 && x < getSize() && y < getSize()
                //check element
                && get(x,y) == me;
    }

    public static void main(String[] args)
    {
        ShellingSegregationModel ssm = new ShellingSegregationModel(10);
        ssm.print("Randomly generated field");       
        ssm.printSameNeighorsCount("Same neighbors count");
        ssm.iterate(5);
        ssm.print("Field after 5 iterations");       
        ssm.printSameNeighorsCount("Same neighbors count");
        ssm.iterate(5);
        ssm.print("Field after 10 iterations");       
        ssm.printSameNeighorsCount("Same neighbors count");
        ssm.iterate(5);
        ssm.print("Field after 15 iterations");       
        ssm.printSameNeighorsCount("Same neighbors count");
        ssm.iterate(50);
        ssm.print("Field after 65 iterations");       
        ssm.printSameNeighorsCount("Same neighbors count");
    }
}