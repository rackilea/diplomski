public final class Util {

    private Util() {
    }

    public static void doOperation(int[] vector1, int[] vector2) {
        int[] result = new int[3];
        result[0] = vector1[0] + vector2[2];
        result[1] = vector1[1] + vector2[1];
        result[2] = vector1[2] + vector2[0];
        return result;
    }

}


public class Backup {

    private final int[] vectorBackup = new int[3];

    public Backup(int[] vector) {
        vectorBackup[0] = vector[0];
        vectorBackup[1] = vector[1];
        vectorBackup[2] = vector[2];
    }

    public int[] restore(){
     //some code to create vector from backup
    }

}