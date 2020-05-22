@GetMapping("/public/properties")
@Timed
public ResponseEntity<List<Property>> getAllPropertiesNested(HttpServletRequest request) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {


    HttpHeaders headers = null;
    if (requestContains("bedrooms", request)) {

        HousePropertyCriteria housePropertyCriteria = new HousePropertyCriteria();
        applyMapOntoInstance(housePropertyCriteria, request.getParameterMap());

        Page<HouseProperty> page = housePropertyQueryService.findByCriteriaNested(housePropertyCriteria, pageable);
        headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/public/properties");
        return new ResponseEntity(page.getContent(), headers, HttpStatus.OK);

    } else {
        Page<Property> page = propertyQueryService.findByCriteriaNested(criteria, pageable);
        headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/public/properties");
        return new ResponseEntity(page.getContent(), headers, HttpStatus.OK);
    }


}