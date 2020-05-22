@PreAuthorize("#oauth2.hasScope('openid') and hasRole('ROLE_ADMIN')")
@RequestMapping(value = "secret", method = RequestMethod.GET)
@ResponseBody
public String helloSecret(Principal principal) {
    return principal == null ? "Hello anonymous" : "S3CR3T  - Hello " + principal.getName();
}