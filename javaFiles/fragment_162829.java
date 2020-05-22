@RequestMapping("/deleteUser")
@ResponseBody
public String deleteKpi(@RequestParam(value = "userId") Long userId,  HttpSession session) {

    if (null != userId) {
        userService.deleteUser(userId);
        return "Ok";
    }
    return "NotOk";
}