public class DownloadFileAction extends Action{

 @Override
 public ActionForward execute(ActionMapping mapping, ActionForm form,
   HttpServletRequest request, HttpServletResponse response)
 throws Exception {

  String filepath = httpServletRequest.getParameter("filepath");
  response.setContentType("application/octet-stream");
  response.setHeader("Content-Disposition","attachment;filename=statistic.csv");

  try 
  {
    FileInputStream in = 
        new FileInputStream(new File(filepath));
    ServletOutputStream out = response.getOutputStream();
    byte[] outputByte = new byte[4096];
    while(in.read(outputByte, 0, 4096) != -1){
     out.write(outputByte, 0, 4096);
   }
   in.close();
   out.flush();
   out.close();

 }catch(Exception e){
   e.printStackTrace();
 }

 return null;
 }
}