import static x.y.z.Mockito.*;

ObjectA objectA = mock(ObjectA.class);
when(objectA.getIntValue()).thenReturn(1));

Conn conn1 = mock(Conn.class);
when(conn1.getObjectA()).thenReturn(objectA);

ClassA.conn1 = conn1;