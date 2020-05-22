@GetMapping("/users")
public ResponseEntity<User> userLogin(@RequestParam String username,@RequestParam String password) {

    User user = userService.findByUsername(username);

    if(user==null) {
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    if(user.getPassword().equals(password)) {
        return new ResponseEntity<>(user,HttpStatus.OK);
    } else {
        return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
    }

}