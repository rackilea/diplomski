// Needs Class<Example> but found Class<E1> and Class<E2>
test(new Class<Example>[]{E1.class,E2.class});

// Needs Class<E1> but found Class<E2>
test(new Class<E1>[]{E1.class,E2.class}); 

// Needs Class<E2> but found Class<E1>
test(new Class<E2>[]{E1.class,E2.class});