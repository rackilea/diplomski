public class Ws {
    @ActivationRequestParameter("hipchat_id") private int hipchat_id;
    @ActivationRequestParameter("name") private String name;
    @ActivationRequestParameter("dips") private int dips;

    @Property
    private Competitor competitor;

    @Inject
    private Session session;

    @SetupRender
    @CommitAfter
    void appUpdate() {
        session.saveOrUpdate(new Competitor(hipchat_id, name, dips));
        session.save(new Record(hipchat_id, dips));
    }

}