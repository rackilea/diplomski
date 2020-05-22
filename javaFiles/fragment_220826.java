import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class MyClassTest {
    private MyClass myClass;
    private SomeClass mockSomeClassObj;
    private ClassB mockClassBObj;

    @Before
    public void setUp() throws Exception {
        this.mockSomeClassObj = EasyMock.createMock(SomeClass.class);
        this.mockClassBObj = EasyMock.createMock(ClassB.class);

        this.myClass = new MyClass();
        this.myClass.classBObj = this.mockClassBObj;
    }

    @Test
    public void thatMethodDoesExpectedThings() {
        //Add some expectations for how the mockClassBObj is used within the addParam and getClassCObj methods

        final Capture<ClassC> classCCapture = new Capture<ClassC>();
        EasyMock.expect(this.mockSomeClassObj.getResult( EasyMock.capture(classCCapture) ) ).andReturn(9);

        EasyMock.replay(this.mockClassBObj, this.mockSomeClassObj);

        final int result = this.myClass.myMethod(this.mockSomeClassObj);
        assertThat(result,  is(9));

        EasyMock.verify(this.mockClassBObj, this.mockSomeClassObj);

        final ClassC classCobject = classCCapture.getValue();
        //Some assertions about the classC object
    }
}