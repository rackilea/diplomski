public class EarthquakeMonitor {

    private Map<Observatory, SortedSet<Earthquake>> quakes = new HashMap<>();

    public void reportQuake(Observatory obs, Earthquake quake) {
        if (!quakes.contains(obs)) {
            quakes.put(obs, new SortedSet<>(new ObsObsComp<Earthquake>());
        }
        quakes.get(obs).add(quake);
    }

    public double getAvgMagnitude (Observatory obs) {
        return getQuakes(obs).stream(mapToDouble(Earthquake::getMagnitude).average().getAsDouble();
    }


    /**
     * Pretty formats earthquakes per observatory.
     *
     *@return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<Observatory, SortedSet<Earthquake>> entry : quakes.entrySet()) {
            sb.append("Observatory: ").append(entry.getKey().toString()).append("\n");
            for (Earthquake q : entry.getValues()) {
                sb.append("\t").append(q.toString());
            }
        }
    }
}