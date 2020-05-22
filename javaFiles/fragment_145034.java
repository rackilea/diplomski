package com.example;

@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes=OrderServiceConfig.class, loader=AnnotationConfigContextLoader.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testOrderService() {
        // test the orderService
    }
}