public class TrendBeanTest {

@Tested
TrendBean trendBean;
@Injectable
LoginBean loginBean;
@Injectable
Session session;
@Injectable
ITrendManager manager;
@Injectable
IUserManager userManager;
@Injectable
User user;

@Test
public void testAddChartPoint(@Mocked FacesContext fakeContext, @Mocked AbstractBean abstractBean) {

    new NonStrictExpectations() {

        {
            session.isLoggedIn();
            result = true;
            session.getUser();
            result = user;
            manager.addPointToUser((User) any, (ChartPoint) any);
            FacesContext.getInstance();
            result = fakeContext;
            abstractBean.getMessage(anyString); result = "foo";
        };
    };

    Deencapsulation.setField(trendBean, "point", new ChartPoint());

    assertEquals(null, trendBean.addChartPoint());

    new Verifications(){{
        fakeContext.addMessage(withNull(), (FacesMessage)any); 
    }};
}
}