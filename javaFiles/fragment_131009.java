private static final Pattern ACCEPTED_CHARACTERS = Pattern.compile("^[a-z0-9\\-]+$");

@RequestMapping("/data/{id}")
public ResponseEntity<Data> getData(@PathVariable String id)
{       
    if (!ACCEPTED_CHARACTERS.matcher(id).matches()) {
      return new ResponseEntity<>("Your messge", YOUR CODE);
    }
    Data messages = dataService.getData(id, Data.DataFormat.ALL);
    return new ResponseEntity<>(messages, HttpStatus.OK);
}