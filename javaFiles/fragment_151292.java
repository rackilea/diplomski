public class RecursivePyramid {

    public static void WriteOutPyramidLevel(int level,int height) {

        // Need counter in loops 
        int counter;

        // Writing spaces in front - using asterix for visible debugging
        for (counter=height ;counter > level; counter-- ) 
          System.out.print("*");

        // Writing numbers in front
        for (counter=level ;counter > 1; counter-- ) 
            System.out.print(counter);                    

        // Writing central «line» in Pyramid    
        System.out.print(1);

        // Writing numbers after central line
        for (counter=2 ;counter <= level; counter++ ) 
            System.out.print(counter);

        // Writing spaces after central line - can of course be removed   
        for (counter=level ;counter < height; counter++) 
            System.out.print("*"); 

        // Line finished
        System.out.println();

        // If below height of Pyramid go again - max 9 allowed 
        if (level < height && level < 9)
          WriteOutPyramidLevel(level+1,height);        
    }

    public static void main(String[] parameters) {

        WriteOutPyramidLevel(1,10);        
    }
}