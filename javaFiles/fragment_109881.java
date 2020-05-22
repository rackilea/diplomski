model.put("athleteStats", athleteStats);
Map<Integer, String> dynamicValues = new HashMap<Integer, String>();
for(AthleteStat athleteStat : athleteStats) {
   String dynValue = athleteStat.toString(); /* calculate the dynamic value */
   dynamicValues.put(athleteStat.getId(), dynValue);
}
model.put("dynamicValues", dynamicValues);