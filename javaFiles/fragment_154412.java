webClient.getPage(openUrl);

Thread.sleep(60000);

// then get the same page again
webClient.getPage(openUrl);