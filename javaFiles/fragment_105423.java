@RequestMapping("404")
String get404ErrorPage() {
    return "404";
}

@RequestMapping("401")
String get401ErrorPage() {
    return "401";
}