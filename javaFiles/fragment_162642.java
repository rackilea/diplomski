if (actualTitle.contentEquals(expectedTitle)) {
    logger.log(Level.INFO, "{0} Access Test Pass {1,date} {1,time}",
              new Object[]{accessnames[j] , System.currentTimeMillis()});
} else {
    logger.log(Level.INFO, "{0} Access Test Failed {1,date, EEE, MMM dd HH:mm:ss:S ZZZ yyyy}",
              new Object[]{accessnames[j] , System.currentTimeMillis()});
}