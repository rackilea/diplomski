try {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Message> response =
                rest.getForEntity("http://localhost:80/messageApp-api/getMessage/{id}", Message.class, id);

        model.addAttribute(MESSAGE, response.getBody());
    } catch (HttpStatusCodeException e) {
      if (HttpStatus.NOT_FOUND == e.getStatusCode()) {
          model.addAttribute(MESSAGE, EMPTY_MESSAGE);
      }
      //handle other errors here
    }