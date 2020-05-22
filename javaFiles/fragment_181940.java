long timeElapsed = 7564000; //For example
int hours = (int) (timeElapsed / 3600000);
int minutes = (int) (timeElapsed - hours * 3600000) / 60000;
int seconds = (int) (timeElapsed - hours * 3600000 - minutes * 60000) / 1000;
//hours = 2
//minutes = 6
//seconds = 4