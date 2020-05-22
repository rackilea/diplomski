@Transactional(propagation = REQUIRES_NEW, rollbackFor = {Exception.class})
public void saveAndSendMessage(Foo foo) throws Exception {
    dbManager.save(foo);
    Bar bar = transform(foo);
    jmsSystem.send(bar);
}