@RequestMapping(value="/*/test2.do")
public void getMeta5(HttpServletRequest request, HttpServletResponse response) throws IOException {
    final PrintWriter writer = response.getWriter();
    writer.print("requestURI:" + request.getRequestURI());
    writer.flush();
}