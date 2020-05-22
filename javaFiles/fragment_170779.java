@RequestMapping(value = "/prenotazioni/{id}", method = RequestMethod.OPTIONS)
    public void updatePrenotazione(HttpServletResponse response, @PathVariable int id) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        response.addHeader("Access-Control-Allow-Headers", "accept, content-Type");
    }