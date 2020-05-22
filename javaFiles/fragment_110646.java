public class EnumIssue {

    enum Job
    {
        SPAWN, KING, NORM
    }
    enum myColor
    {
        RED, BLACK
    }

    public static void main(String[] args) {
        Job j = Job.SPAWN;
        myColor c = myColor.BLACK;
        System.out.println(j);
        System.out.println(c);
    }
}