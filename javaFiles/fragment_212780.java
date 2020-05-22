@Component
public class ContestFlow {  

    static Logger logger = LoggerFactory.getLogger(ContestFlow.class);

    @Autowired
    private ServiceService ServiceService;

    @Autowired
    private AgencyService AgencyService;

    /**
     * input: a comma separated string with all ids checked from the POST
     * 
     * @param contest:      contest object that i will add at the end of the webflow
     * @param ids_string:   comma separated string with checked ids
     * @return
     */
    public Set<ContestService> converterCheckboxToSetContestService(Contest contest, String ids_string)
    {

        Set<ContestService> contestServices = new HashSet<ContestService>(0);   

        if (ids_string != null)
        {
            String[] arr_ids = ids_string.split(",");

            /*
             * for each record i get the Service
             */
            for (int i = 0; i < arr_ids.length; i++)
            {
                try
                {
                    //get the Service
                    Service service = ServiceService.getService(Integer.parseInt(arr_ids[i]));

                    logger.info("Aggiungo il service id [" + arr_ids[i] + "]");

                    //creation of the Id object
                    ContestServiceId contestServiceId = new ContestServiceId();             
                    contestServiceId.setService(service);
                    contestServiceId.setContest(contest);

                    //record population
                    ContestService contestService = new ContestService();
                    contestService.setService(service);
                    contestService.setContest(contest);
                    contestService.setPk(contestServiceId);

                    //add the record
                    contestServices.add(contestService);

                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    logger.info("Service id [" + arr_ids[i] + "] not found!");

                }       

            }       
        }           
        return contestServices;
    }


    /**
     * input: Set of ContestAgency (many-to-many) checked 
     * and returns a List<String> of ids to be used to select checkboxes 
     * in thymeleaf view with th:checked="${#lists.contains(checked_agencies, '' + agency_el.id)}"
     * 
     * i can't return a List<Integer> because it doesn't check the checkboxes
     * 
     * @param contestAgencies
     * @return
     */
    public List<String> converterSetContestServiceToCheckbox(Set<ContestService> contestServices)
    {
        List<String> result = new ArrayList<String>();

        if (contestServices != null)
        {
            Iterator<ContestService> iterator = contestServices.iterator();
            while(iterator.hasNext()) 
            {           
                ContestService contestService = iterator.next();            

                Integer id = contestService.getService().getId();

                result.add(id.toString());
            }  
        }

        return result;
    }




    //same as above, for the Agencies:





    /**
     * input: a comma separated string with all ids checked from the POST
     * 
     * @param contest:      contest object that i will add at the end of the webflow
     * @param ids_string:   comma separated string with checked ids
     * @return
     */
    public Set<ContestAgency> converterCheckboxToSetContestAgency(Contest contest, String ids_string)
    {

        Set<ContestAgency> contestAgencies = new HashSet<ContestAgency>(0); 

        if (ids_string != null)
        {
            String[] arr_ids = ids_string.split(",");

            /*
             * for each record i get the Agency
             */
            for (int i = 0; i < arr_ids.length; i++)
            {
                try
                {
                    //get the Agency
                    Agency agency = AgencyService.getAgency(Integer.parseInt(arr_ids[i]));

                    logger.info("Adding agency id [" + arr_ids[i] + "]");

                    //creation of the Id object
                    ContestAgencyId contestAgencyId = new ContestAgencyId();                
                    contestAgencyId.setAgency(agency);
                    contestAgencyId.setContest(contest);

                    //record population
                    ContestAgency contestAgency = new ContestAgency();
                    contestAgency.setAgency(agency);
                    contestAgency.setContest(contest);
                    contestAgency.setPk(contestAgencyId);
                    contestAgency.setContractCount(0);  //my many-to-many relationship has an additional field

                    //add the record
                    contestAgencies.add(contestAgency);

                }
                catch(RecordNotFoundException ex)
                {
                    ex.printStackTrace();
                    logger.info("Agency id [" + arr_ids[i] + "] not found!");

                }       

            }       
        }       
        return contestAgencies;
    }


    /**
     * input: Set of ContestAgency (many-to-many) checked 
     * and returns a List<String> of ids to be used to select checkboxes 
     * in thymeleaf view with th:checked="${#lists.contains(checked_agencies, '' + agency_el.id)}"
     * 
     * i can't return a List<Integer> because it doesn't check the checkboxes
     * 
     * @param contestAgencies
     * @return
     */
    public List<String> converterSetContestAgencyToCheckbox(Set<ContestAgency> contestAgencies)
    {
        List<String> result = new ArrayList<String>();

        if (contestAgencies != null)
        {
            Iterator<ContestAgency> iterator = contestAgencies.iterator();
            while(iterator.hasNext()) 
            {
                ContestAgency contestAgency = iterator.next();

                Integer id = contestAgency.getAgency().getId();

                result.add(id.toString());
            }       
        }   

        return result;
    }

}