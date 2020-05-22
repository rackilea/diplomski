String line = "{\"method\":\"GET\",\"status\":\"200 - OK\"}";
AnalysisReport report = new AnalysisReport();
Gson gson = new GsonBuilder().create();
JsonReader reader = new JsonReader(new StringReader(line));
reader.setLenient(true); //accept malformed input

report = gson.fromJson(line, AnalysisReport.class); //this doesn't work

reader.close();
System.out.println(report.toString());