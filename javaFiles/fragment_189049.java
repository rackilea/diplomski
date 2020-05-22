/*
double dValue = mediaIn.duration;
int hours = (int)(dValue/3600f);
dValue -= (hours*3600);

cmd.add("0");
cmd.add(String.format(Locale.US,"%s",hours));
cmd.add(":");

int min = (int)(dValue/60f);
dValue -= (min*60);

cmd.add("0");
cmd.add(String.format(Locale.US,"%s",min));
cmd.add(":");

cmd.add(String.format(Locale.US,"%f",dValue));
*/
cmd.add(Double.toString(mediaIn.duration));