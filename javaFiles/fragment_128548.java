final JavaScriptJobManager tmpJobManager = aHtmlPage.getEnclosingWindow().getJobManager();

int tmpJobCount = tmpJobManager.getJobCount();
if (tmpJobCount > 0) {
  .....
}