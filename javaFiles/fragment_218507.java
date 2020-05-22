@RequestMapping(value = "/graph/{graphId}/details/**", 
                method = RequestMethod.GET,
                produces = MediaType.APPLICATION_JSON_VALUE)
@Timed
public JSONObject getGraph(@PathVariable Long graphId, 
                           HttpServletRequest request) {
    String iri = (String) request.getAttribute(
        HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    log.debug("Details called for graph ID {} for IRI {}", graphId, iri);
    return detailsService.getDetails(graphId, iri);
}