public ActorRef getActor(Class<? extends UntypedActor> clsActor, int id)
{
    String sName = clsActor.getName() + "-" + id;
    ActorSelection sel = m_actorSystem.actorSelection("user/" + sName);
    Timeout timeout = new Timeout(100, TimeUnit.MILLISECONDS);
    Future<ActorRef> fut = sel.resolveOne(timeout);
    ActorRef actor= Await.result(fut, timeout.duration());

    return actor;
}