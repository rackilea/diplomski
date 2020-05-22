import org.apache.commons.lang.mutable.MutableInt;
import org.easymock.IAnswer;
import org.junit.Test;
import static org.easymock.EasyMock.*;

public class TestSet {
    @Test
    public void testSetGet() {
        final MutableInt value = new MutableInt();

        GetSetId id = createMock(GetSetId.class);
        id.setID(anyInt());
        expectLastCall().andAnswer(new IAnswer<Object>() {

            @Override
            public Object answer() throws Throwable {
                Object[] arguments = getCurrentArguments();
                value.setValue((Integer) arguments[0]);
                return null;
            }

        });
        expect(id.getID()).andAnswer(new IAnswer<Integer>() {

            @Override
            public Integer answer() throws Throwable {

                return value.toInteger();
            }

        });

        replay(id);
        id.setID((int) (Math.random() * 100.0));
        System.out.println(id.getID());
        verify(id);
    }
}

interface GetSetId {
    public int getID();
    public void setID(int id);
}