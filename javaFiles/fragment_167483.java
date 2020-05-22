@Component
    @RestControllerEndpoint(id = "remote")
    public class CustomActuator {
        @RequestMapping(value = {"/{actuatorInput}"}, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
        @ResponseBody
        public Map<String, Object> feature(@PathVariable("actuatorInput") String actuatorInput) {
            System.out.println("actuatorInput : " + actuatorInput);
            Map<String, Object> details = new HashMap<>();
            details.put("input", actuatorInput);
            return details;
        }
    }