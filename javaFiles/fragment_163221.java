Date now = new Date();   
Date earlyesPossibleLogin = now - maxLoginDuration //This is psydo code, I can subtact something from a date
CronExpression cron = new CronExpression("....");
Date allowedLoginSinceEarlyestLogin = cron.getNextValidTimeAfter(earlyesPossibleLogin);
if(allowedLoginSinceEarlyestLogin > now) {
   throw new LoginDeniedException("you are out of your window.");
}