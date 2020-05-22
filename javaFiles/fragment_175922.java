@RequestMapping(value = {"/getDetails","/getDetailsMore"}, method = RequestMethod.GET)
    public String getCustomerDetails(TestFormBean bean) {
        RequestAttributes reqAttributes = RequestContextHolder.currentRequestAttributes();
    System.out.println(reqAttributes.getAttribute(BEST_MATCHING_PATTERN_ATTRIBUTE, 0));
    System.out.println(reqAttributes.getAttribute(LOOKUP_PATH, 0));
    System.out.println(reqAttributes.getAttribute(PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE, 0));

        return "test";
    }}