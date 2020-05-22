int year;//extract year from data
int month;//extract month from data
String baseFileName; //parent directory to all outputs from this job
String outputFileName = baseFileName + "/" + year + "/" + month;

mout.write("Output",new Text(key),new Text(value),outputFileName);