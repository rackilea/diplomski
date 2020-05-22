@WebServlet(Array("/upload"))
class UploadServlet extends HttpServlet {

    @Override
    override def doPost(request: HttpServletRequest, response: HttpServletResponse) {
        println(request.getParameter("name"));
        val input = Source.fromInputStream(request.getInputStream)
        input.getLines() foreach println
        println("Done")
    }

}