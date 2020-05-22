@RequestMapping(value = "/math", method = RequestMethod.POST)
        public ResponseEntity calculate(@RequestBody @Valid MatchRequest request, BindingResult result) {
            if (result.hasErrors()) {
                return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_GATEWAY);
            }

            //call service,etc.
        }