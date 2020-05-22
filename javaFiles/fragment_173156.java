T03CallsLog newCall = null;
List results = q1.getResultList();
if (!results.isEmpty())
   newCall = (T03CallsLog) results.get(0);
else
   // is it a problem? -> log.