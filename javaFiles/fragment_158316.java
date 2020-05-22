@RequestMapping("/role/add.action")
@ResponseBody
public Map<String,Object> addRole(@RequestBody Role role, 
            HttpServletRequest request,
            Authentication authentication,
            HttpServletResponse response) {

            ...
}