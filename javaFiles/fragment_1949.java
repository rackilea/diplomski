import static org.apache.commons.lang3.ArrayUtils.contains;

public class Sample {

    public boolean isALive(boolean isLive, int num) {

        int[] liveValues = {3};
        int[] deadValues = {2, 3};

        int[] validValues = isLive ? liveValues : deadValues;
        return contains(validValues, num);
    }
}