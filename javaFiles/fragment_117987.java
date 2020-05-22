// during startup
final MutablePicoContainer root = new PicoBuilder().build();
root.addComponent(C.class, C.class);

// later, initialize sessions
final MutablePicoContainer session = new PicoBuilder(root)
    .implementedBy(TransientPicoContainer.class)
    .build();
session.addComponent(B.class, B.class);
session.addComponent(new A());

// some request
System.out.println(session.getComponent(B.class));