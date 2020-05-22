int wage = 0;
String key = null;
for (Map.Entry<String, People> entry : ppl.entrySet()) {
    People s = entry.getValue();
    if (s instanceof Employee) {
        int empWage = ((Employee) s).getWage();
        if (empWage > wage) {
            wage = empWage;
            key = entry.getKey();
        }
    }
}
return key;