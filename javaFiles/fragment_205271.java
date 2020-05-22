package...

 import...



 @Service
 @Scope("prototype")
 public class AlternateTravelPlan {


 private TravelPlanRepo travelPlanRepo;

 //By autowiring constructors we avoid NPEs...
 @Autowired
 public AlternativeTravelPlan(TravelPlanRepo travelPlanRepo){
      this.travelPlanRepo = travelPlanRepo;
 }

 public List<Site> getItinerary() {

      List siteList = new ArrayList();
      //Enhance For Loop to fetch Site List from Database
      for (Site site : travelPlanRepo.findAll()) {
           siteList.add(site);
      }
      return siteList;
}
}