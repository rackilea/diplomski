import java.util.Arrays;

public boolean isInArray(int[] sub, int[][] sup){
    for(int i=0; i<sup.length; i++)
        if(Arrays.equals(sub, sup[i]))
            return true;
    return false;
}