Double existingValue = costByDuration.get(callFrom);
if (existingValue != null) {
    costByDuration.put(callFrom, existingValue + toPay);
}  else {
    costByDuration.put(callFrom, toPay);
}