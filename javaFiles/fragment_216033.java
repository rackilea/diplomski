@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
                         HttpServletRequest request, HttpServletResponse response)
    throws Exception {

String filepath = request.getParameter("filepath");
File statisticFile = new File(filepath);

byte[] ourArray = new byte[Integer.parseInt(statisticFile.length() + "")];

response.setContentType("application/octet-stream");
response.setHeader("Content-Disposition", "attachment;filename=" + statisticFile.getName());

FileInputStream in = new FileInputStream(statisticFile);
ServletOutputStream out = response.getOutputStream();

try {
    int c;
    while ((c = in.read()) != -1) {
        out.write(c);
        out.flush();
    }
} finally {
    if (in != null) {
        in.close();
    }
    if (out != null) {
        out.close();
    }
}
return null;
}