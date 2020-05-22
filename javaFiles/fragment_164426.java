@RequestMapping("/folder")
public ModelAndView folder(HttpServletRequest request) {
    int folderid = Integer.parseInt(request.getParameter("folderid"));
    int userid = (Integer) request.getSession().getAttribute("userid");
    request.getSession().setAttribute("folderid", folderid);

    ArrayList<Files> files;

    FileSharingDao fileShare = new FileSharingDao();
    try {
        files = fileShare.getFiles(folderid, userid);
        request.setAttribute("files", files);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return new ModelAndView("folder");
}