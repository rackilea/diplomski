import java.util.*;

class Officer {
}

public class Test {

    public static void main(String[] args) {

        List<Officer> officers = new ArrayList<Officer>();

        Collections.max(officers, new Comparator<Officer>()
                {
                    public int compare( Officer a, Officer b )
                    {
                       return -1; //will do after
                    }
                }
            );
    }
}