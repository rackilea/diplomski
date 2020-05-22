public class WebUsageLog {
    private Collection<LogLine> logLines;
    private Collection<Date> dates;

    WebUsageLog() {
        this.logLines = new ArrayList<LogLine>();
        this.dates = new ArrayList<Date>();
    }

    SortedMap<Double, String> getFrequency(LineProperty property) {
        SortedMap<Double, String> frequencyMap = new TreeMap<Double, String>(Collections.reverseOrder()); //we reverse order to sort from the highest percentage to the lowest.
        Collection<String> values = new HashSet<String>();
        Frequency freq = new Frequency();
        for (LogLine line : this.logLines) {
            freq.addValue(property.getValue(line));
            values.add(property.getValue(line));
        }

        for (String value : values) {
            frequencyMap.put(freq.getPct(value), value);
        }

        return frequencyMap;
    }

    public enum LineProperty {
        VISITED_DOMAIN {
            @Override
            public String getValue(LogLine line) {
                return line.getVisitedDomain();
            }
        },
        CATEGORY {
            @Override
            public String getValue(LogLine line) {
                return line.getCategory();
            }
        },
        VERDICT {
            @Override
            public String getValue(LogLine line) {
                return line.getVerdict();
            }
        };

        public abstract String getValue(LogLine line);
    }
}