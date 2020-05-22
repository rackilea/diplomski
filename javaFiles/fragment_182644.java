import javax.validation.Valid;
...
@GetMapping("/users")
public ResponseEntity<UserDto> getUsers(@Valid Filter filter) {
    return ResponseEntity.ok(userService.findUsers(filter));
}