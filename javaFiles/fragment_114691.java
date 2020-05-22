private DistanceTime distance;

     @Autowired
    public void setDistance(DistanceTime distance) {
    this.distance = distance;
}


    public ModelAndView Api(@RequestParam("picking_up") String source,@RequestParam("dropping_off") String destination,@RequestParam("pick_up_date") String time) {
            try {
                  //method of DistanceTime Class
                String response=distance.calculate(source,destination);

            System.out.println(response);
            }

            catch(Exception e) {
                System.out.println("Exception Occurred");
            }

            return new ModelAndView("home");

        }