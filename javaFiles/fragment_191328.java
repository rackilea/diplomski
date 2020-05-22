public class DateExpressions {
    private Map<String, Date> dateVariables;
    private Map<String, Integer> temporalUnits;
    private Map<Character, Integer> temporalOperations;

    public static DateExpressions createInstance() {
        DateExpressions de = new DateExpressions();
        Calendar c = Calendar.getInstance();
        de.setVariable("NOW", c.getTime());

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        de.setVariable("DayStart", c.getTime());

        c.set(Calendar.DAY_OF_MONTH, 1);
        de.setVariable("MonthStart", c.getTime());

        return de;
    }

    public DateExpressions() {
        this.dateVariables = new HashMap<String, Date>();
        this.temporalUnits = new HashMap<String, Integer>();
        this.temporalUnits.put("Second", Calendar.SECOND);
        this.temporalUnits.put("Minute", Calendar.MINUTE);
        this.temporalUnits.put("Hour", Calendar.HOUR_OF_DAY);
        this.temporalUnits.put("Day", Calendar.DATE);
        this.temporalUnits.put("Month", Calendar.MONTH);
        this.temporalUnits.put("Year", Calendar.YEAR);

        this.temporalOperations = new HashMap<Character, Integer>();
        this.temporalOperations.put('+', 1);
        this.temporalOperations.put('-', -1);
    }

    public void setVariable(String key, Date value) {
        this.dateVariables.put(key, value);
    }

    public Date parseExpression(String expr) throws IOException {
        StringReader sr = new StringReader(expr);
        String s;
        int n;
        char c;

        int offset;
        int unit;
        int op = 1;

        Calendar base = null;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while ((n = sr.read()) != -1) {
            c = (char) n;

            if (base == null && temporalOperations.containsKey(c)) {
                s = sb2.toString();
                if (!dateVariables.containsKey(s)) {
                    throw new IOException("Unknown variable '" + s + "' used");
                }

                base = Calendar.getInstance();
                base.setTime(dateVariables.get(sb2.toString()));
                op = temporalOperations.get(c);

                sb1.setLength(0);
                sb2.setLength(0);
            } else if (temporalOperations.containsKey(c)) {
                if (!temporalUnits.containsKey(sb2.toString())) {
                    throw new IOException(
                            "Parse error: unknown temporal unit used '"
                                    + sb2.toString() + "'");
                }

                offset = Integer.parseInt(sb1.toString());
                unit = temporalUnits.get(sb2.toString());

                base.add(unit, op * offset);

                op = temporalOperations.get(c);
                sb1.setLength(0);
                sb2.setLength(0);
            } else if (Character.isDigit(c)) {
                sb1.append(c);
            } else {
                sb2.append(c);
            }
        }

        if (!temporalUnits.containsKey(sb2.toString())) {
            throw new IOException("Parse error: unknown temporal unit used '"
                    + sb2.toString() + "'");
        }

        offset = Integer.parseInt(sb1.toString());
        unit = temporalUnits.get(sb2.toString());

        base.add(unit, op * offset);

        return base.getTime();
    }

    public static void main(String[] args) throws IOException {
        DateExpressions de = DateExpressions.createInstance();
        System.out.println(de.parseExpression("DayStart+2Hour+1Day-2Minute"));
        System.out.println(de.parseExpression("NOW+20Day"));
        System.out.println(de.parseExpression("MonthStart+1Month"));
    }
}