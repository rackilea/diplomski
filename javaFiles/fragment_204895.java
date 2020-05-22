package reports.utils;

import java.util.Map;

/**
 * Utility that allows you to sum Integer values.
 */
public class SumCalculator {

    /**
     * Stores a map of {@code SumCalculator} instances (A Map instance per thread).
     */
    private static final ThreadLocalMap<String, SumCalculator> calculatorsIndex = new ThreadLocalMap<>();

    /**
     * The sum total.
     */
    private int total = 0;


    /**
     * No arguments class constructor.
     */
    private SumCalculator() {
        super();
    }


    /**
     * Instance a new {@code SumCalculator} with the given ID.
     *
     * @param id    {@code SumCalculator}'s ID
     * @return      the new {@code SumCalculator} instance
     */
    public static SumCalculator get(String id) {
        Map<String, SumCalculator> map = calculatorsIndex.get();
        SumCalculator calculator       = map.get(id);

        if (calculator == null) {
            calculator = new SumCalculator();
            map.put(id, calculator);
        }
        return calculator;
    }


    /**
     * Destroy the {@code SumCalculator} associated to the given ID.
     *
     * @param id    {@code SumCalculator}'s ID
     * @return      {@code null}
     */
    public static String destroy(String id) {
        Map<String, SumCalculator> map;

        map = calculatorsIndex.get();
        map.remove(id);

        if (map.isEmpty()) {
            calculatorsIndex.remove();
        }
        return null;
    }


    /**
     * Resets the {@code SumCalculator} total.
     *
     * @return  {@code null}
     */
    public String reset() {
        total = 0;
        return null;
    }


    /**
     * Adds the given integer value to the accumulated total.
     *
     * @param i     an integer value (can be null)
     * @return      {@code null}
     */
    public String add(Integer i) {
        this.total += (i != null) ? i.intValue() : 0;
        return null;
    }


    /**
     * Return the accumulated total.
     *
     * @return  an Integer value (won't be null, never!)
     */
    public Integer getTotal() {
        return this.total;
    }
}