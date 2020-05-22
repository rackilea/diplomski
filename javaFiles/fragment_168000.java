public class AdminController {
            private final RestaurantCardService restaurantcardService;
            private final ContentsectionService contentsectionService;
            public AdminController (final RestaurantCardService rcs,final ContentsectionService  css){
                this.restaurantcardService       = rcs;
                this.contentsectionService       = css;
            }

 AdminController  ac = new AdminController (new RestaurantCardServiceImpl(),new ContentsectionServiceImpl());


            so for unit testing you can pass mock services;

            for intance:


    AdminController  ac = new AdminController (new MockRestaurantCardServiceImpl(), new MockContentsectionServiceImpl());