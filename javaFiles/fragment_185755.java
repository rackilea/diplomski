public class ChildTest extends TestCase {
    Mockery context = new Mockery();
    States test = context.states("test");

    Parent parent = context.mock(Parent.class);

    // This is created in setUp
    Child child;

    @Override
    public void setUp() {
        context.checking(new Expectations() {{
            ignoring (parent).addChild(child); when(test.isNot("fully-set-up"));
        }});

        // Creating the child adds it to the parent
        child = new Child(parent);

        test.become("fully-set-up");
    }

    public void testRemovesItselfFromOldParentWhenAssignedNewParent() {
        Parent newParent = context.mock(Parent.class, "newParent");

        context.checking(new Expectations() {{
            oneOf (parent).removeChild(child);
            oneOf (newParent).addChild(child);
        }});

        child.reparent(newParent);
    }
}