import java.io.*; 
    import com.gargoylesoftware.htmlunit.html.HtmlPage;
    import com.gargoylesoftware.htmlunit.html.HtmlTable;
    import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
    import com.gargoylesoftware.htmlunit.html.*;
    import com.gargoylesoftware.htmlunit.WebClient;


    public class test {

    public static void main(String[] args) throws Exception {

    WebClient client = new WebClient();
    HtmlPage currentPage = client.getPage("http://www.mysite.com");
    client.waitForBackgroundJavaScript(10000);

FileWriter fstream = new FileWriter("index.txt");
BufferedWriter out = new BufferedWriter(fstream);



   for (int i=0;i<2;i++){

final HtmlTable table = (HtmlTable) currentPage.getByXPath("//table[@class=' table-main']").get(i);




   for (final HtmlTableRow row : table.getRows()) {

   for (final HtmlTableCell cell : row.getCells()) {
    out.write(cell.asText()+',');
   }
out.write('\n');
   }

   }

out.close();

    client.closeAllWindows();

   }

   }