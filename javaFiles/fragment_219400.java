function removeMyTest() {
  var mymail = "myemailhere@gmail.com";
  var mylabel = "mytest";
  var permanentlyRemoveMyLabel = false;
  var pageToken;
  do {
    var threadList = Gmail.Users.Threads.list('me', {
      q: 'label:' + mylabel,
      pageToken: pageToken
    });
    if (threadList.threads && threadList.threads.length > 0) {
      threadList.threads.forEach(function(thread) {
        Logger.log('id: %s snippet: %s', thread.id, thread.snippet);
        if (permanentlyRemoveMyLabel) {
          Gmail.Users.Threads.remove(mymail, thread.id);
          Logger.log('id: %s snippet: %s REMOVED', thread.id, thread.snippet);
        }
      });
    }
    pageToken = threadList.nextPageToken;
  } while (pageToken);
}