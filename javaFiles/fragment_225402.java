@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springContext.xml"})
@Transactional
public class SpringDAOTest 
{
    @Autowired
    private SpringDAO dao;

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void checkConfig()
    {
        AnySpringBean bean =  appContext.getBean(AnySpringBean.class);
        Assert.assertNotNull(bean);
    }
}