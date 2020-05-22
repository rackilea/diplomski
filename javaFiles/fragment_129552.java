@RestController
class FooController {

    @PreAuthorize("hasAuthority(@securityService.privilege)")
    @GetMapping("/")
    public ResponseEntity<String> helloSecurity(@RequestParam("id") Integer id){
        return ResponseEntity.ok("Hello World");
    }


}

@Service("securityService")
class SecurityService {

    public String getPrivilege(){
        return "CREATE_USER_PRIVILEGE";
    }

}