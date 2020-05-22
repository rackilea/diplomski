@Stateful @LocalBean
public class EmailEJB {
@Inject
private ProgressEJB progress;
// Mail-Settings
...
@Asynchronous
public void sendEmails(user:User, message:Message, sessionId:String) {
  progress.progressMap.put(sessionId, 0);
  for (int i=0; i<mails.size; i++) {
    sendMail(mails[i])
    progress.getProgressMap().put(sessionId, (i / mails.size) * 100)
  }
  progress.getProgressMap().remove(sessionId);
}