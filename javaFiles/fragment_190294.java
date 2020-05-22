@RequestMapping(value = "your_url", method = RequestMethod.POST)
    public ResponseEntity<String> postMethod(HttpServletRequest req) {
        String jsonString = "";
        String empId = req.getParameter("empId");
        // your operation done here and 
        //convert it to json format before sending response.
        jsonString = gson.toJson("your response convert here to json format"); // here i used google Gson library to convert your response in json format.

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=utf-8");
        return new ResponseEntity<String>(jsonString, responseHeaders, HttpStatus.CREATED);
    }