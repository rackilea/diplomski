package com.test.powermock.teststacitejb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.naming.InitialContext;

import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest(XYZClass.class)
public class XYZClassTest {


    private InitialContext ctx;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(XYZClass.class);
        ctx = Mockito.spy(new InitialContext());
        PowerMockito.doReturn(ctx).when(XYZClass.class, "getCtx");

        IMFTPManagerBean service1 = new IMFTPManagerBean();
        Mockito.doReturn(service1).when(ctx).lookup(Mockito.eq("abc"));
        PowerMockito.when(XYZClass.getIMFTPManagerFacade()).thenCallRealMethod();
    }


    @Test
    public void testGetIMFTPManagerFacade() {
        IMFTPManagerService service = XYZClass.getIMFTPManagerFacade();
        assertTrue(service instanceof IMFTPManagerService);
    }
}