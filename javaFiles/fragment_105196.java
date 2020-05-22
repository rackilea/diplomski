public class RunOutOfMemory {
    public static void main(String[] args){
        System.out.println("Haven't tried to allocate lots of heap memory.");
        int[][] matrix = new int[100000][100000000];
        System.out.println("A miracle occured.");
    }
}