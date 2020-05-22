@RequestMapping("/property")
@ResponseBody
public String property(@ModelAttribute("userDto") UserDto userDto ) {
    System.out.println(userDto.getUsername());
    System.out.println(userDto.getPassword());
    return "Hello";
}