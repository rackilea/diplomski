@SessionScoped
@Named
public class EmailManager {
  @Inject 
  private ProgressEJB progress;
  @Inject
  private FacesContext facesContext;

  private String sessionId;

  @PostConstruct
  private void setSessionId() {
    this.sessionId = ((HttpSession)facesContext.getExternalContext().getSession(false)).getId();
  }

  public Integer getProgress() {
    if (progress.getProgressMap().get(sessionId) == null)
      return 100;
    else 
      return progress.getProgressMap().get(sessionId);
  }
}