@RequestMapping(
            value = "/scan",
            method = POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Scan parseScan(@RequestBody Scan rbody) {
        Scan scan = new Scan();
        scan.setProjectId(rbody.getProjectId());
        scan.setTool(rbody.getTool());
        return scan;
    }