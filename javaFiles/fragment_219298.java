import java.io.*;
import java.util.*;

public class scanComparator implements Comparator<Spectrum> {
    public int compare(Spectrum o1, Spectrum o2){
        int s1 = o1.getScanNumber();
        int s2 = o2.getScanNumber();
        int eval = s2 - s1;
        return eval;
    }
}