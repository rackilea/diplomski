@RequestMapping(value = "/addEmployeeRecord", method = RequestMethod.GET)
    public String addEmployeeRecord(@RequestParam(value = "employee_id", defaultValue = "0") Integer testingID_,
            @RequestParam(value = "type_id", defaultValue = "0") Integer type_id,
            @RequestParam(value = "value", defaultValue = "") String definition,
            @RequestParam(value = "rank", defaultValue = "1") Integer rank, HttpServletRequest request

    ) {

        try {

            // Validate the input parameters.
            if (testingID_ < 1) {
                throw new Exception("Invalid Employee ID parameter");
            }
            if (StringUtils.isEmpty(definition)) {
                throw new Exception("Invalid  Definition Parameter");
            }

            // some code

        } catch (Throwable th) {
            th.printStackTrace();
        }

        return "testingID_ " + testingID_ + " type_id- " + type_id + " definition " + definition + " rank " + rank;
    }