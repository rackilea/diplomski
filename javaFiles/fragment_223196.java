MultiValueMap<String, Object> handleSqlRequest(@RequestParam("sql") String sql, 
            @RequestParam("source") String source, @RequestParam("genFile") Boolean genFile) {

    // ......
    MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
    HttpHeaders headers1 = new HttpHeaders();
    headers1.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" 
                           + sqlToolResponse.getZipName()) + "\"");
    HttpEntity<Resource> part1 = new HttpEntity<>(file, headers1);

    HttpHeaders headers2 = new HttpHeaders();
    headers2.setContentType(MediaType.TEXT_PLAIN);
    HttpEntity<String> part2 = new HttpEntity<>(sqlToolReponse.getResult(), headers2);
    body.add("file", part1);
    body.add("string", part2);
    return body;
}