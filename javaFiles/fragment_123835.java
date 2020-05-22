class Phones {
    Map<String, Integer> phones;
    int totals;

    Phones() {
        phones = new HashMap<String, Integer>();
        totals = 0;
    }

    public void addCall(String number, int duration) {
        int sumDuration = duration;
        totals += duration;
        if (phones.containsKey(number) {
            sumDuration += phones.get(number).intValue();
        }
        phones.put(number, Integer.valueOf(sumDuration));
    }

    public Map<String, Integer>getPhones() {
        return phones;
    }
    public int getTotals() {
        return totals;
    }
}