package mypackage;

import org.opencms.file.*;
import org.opencms.main.*;
import org.opencms.scheduler.I_CmsScheduledJob;
import java.text.SimpleDateFormat;
import java.util.*;


public class BuildTagCloud implements I_CmsScheduledJob {

  private final String indexaddress = "address/of/your/index/folder"; // something like ../webapps/opencms/WEB-INF/index/nameOfIndex
  private final String tagsFile = "address"; // part of my template; it's where I store the tag cloud
  private final int numTerms = 10; // number of terms in the tag cloud                                                                   


  public String launch(CmsObject object, java.util.Map parameters) throws java.lang.Exception {
      Cloud cloud = new Cloud(indexaddress, numTerms);

      Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String data;
      data = "<div style=\"border-top: 3px solid #000099; padding-top: 6px; margin-top: 17px;\"><span style=\"font-weight: bold; font-size: 11px; color: #000099;\">Tag cloud</span><br />";
      data += sdf.format(cal.getTime()) + "<br />";

      try {
          List<TermInfo> list = cloud.getCloud();

          for(int i = 0; i<list.size(); i++) {
              data += "<br />" + i + ". " + list.get(i).term.text() + " ... " + list.get(i).docFreq; // list.get(i).docFreq
          }

      } catch (Exception e) {

          data += e.getMessage();
          data += "<br />";

      } finally {

          data+="</div>";
      }

      writeAndPublishResource(object, tagsFile, data);

      return "OK";
  }

  private void writeAndPublishResource(CmsObject object, String resouce, String data) throws java.lang.Exception {
      object.loginUser("administrator's user name", "and his password");

      CmsRequestContext cmsContext = object.getRequestContext();
      CmsProject curProject = cmsContext.currentProject();

      if(curProject.isOnlineProject()){
            CmsProject offlineProject = object.readProject("Name of the project");
            cmsContext.setCurrentProject(offlineProject);
      }
      CmsResource res = object.readResource(resouce);
      object.lockResource(resouce);
      CmsFile file = object.readFile(res);
      file.setContents(data.getBytes());
      object.writeFile(file);
      OpenCms.getPublishManager().publishResource(object, resouce);
      object.unlockResource(resouce);  
  }

}