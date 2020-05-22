@RequestMapping(method = POST)
@ApiOperation(value = "Multipart file upload", notes = "Upload a file to an ID")
@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
public @ResponseBody String uploadFile(@RequestParam(name = "file") MultipartFile file, @PathVariable String key) {

// Store File

}