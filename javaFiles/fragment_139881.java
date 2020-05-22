long now = Calendar.getInstance().getTimeInMillis();
long oneDay = 1000L * 60L * 60L * 24L;
long tenDays = 10L * oneDay;

File log = listOfFiles[i];
long diff = now - log.lastModified();
if (diff > tenDays) {
    log.delete();
}