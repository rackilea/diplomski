@RequestMapping(value = { "/member/uploadExternalImage",
            "/member/uploadExternalImage" }, method = RequestMethod.GET)
    public String handleFileUpload(@RequestParam String url, @RequestParam String fileName,
            RedirectAttributes redirectAttributes, HttpServletResponse resp) {
        ...
        //return new ResponseEntity("Cannot save file " + fileName, HttpStatus.INTERNAL_SERVER_ERROR);
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
            "Cannot save file " + fileName); // explicitely put error message in request
        return null;  // return null to inform Spring that response has already be processed
        ...
        return "redirect:/member/uploadImage";
    }