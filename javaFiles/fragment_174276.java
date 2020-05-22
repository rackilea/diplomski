public class PlanAssembler {

    public static PlanDTO makeDTO(Plan p) {

    PlanDTO result = new PlanDTO();
    result.setProperty(p.getProperty);
    ... 

    for (Activity a: p.getActivity()) {

      ActivityDTO activityDTO = new ActivityDTO();
     // Here I need to iterate over each activity to convert it to DTO
     // But in ActivityAssembler, I also need PlanDTO

     //Code to convert Activity to ActivityDTO.

      activityDTO.setPlan(result);
    }