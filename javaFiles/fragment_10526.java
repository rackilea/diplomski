double finalBuildTime = 10.89;
int hours = (int) finalBuildTime;
int minutes = (int) (finalBuildTime * 60) % 60;
int seconds = (int) (finalBuildTime * (60*60)) % 60;

System.out.println(String.format("%s(h) %s(m) %s(s)", hours, minutes, seconds));