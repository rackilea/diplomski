import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlUnitExampleTestBase {
   public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
      WebClient webClient = new WebClient();
      webClient.setThrowExceptionOnScriptError(false);

      // This is equivalent to typing youtube.com to the adress bar of browser
      HtmlPage currentPage = webClient.getPage("http://www.youtube.com");

      // Get form where submit button is located
      HtmlForm searchForm = (HtmlForm) currentPage.getElementById("masthead-search");

      // Get the input field.
      HtmlTextInput searchInput = (HtmlTextInput) currentPage.getElementById("masthead-search-term");
      // Insert the search term.
      searchInput.setText("Nyan Cat");

      // Workaround: create a 'fake' button and add it to the form.
      HtmlButton submitButton = (HtmlButton) currentPage.createElement("button");
      submitButton.setAttribute("type", "submit");
      searchForm.appendChild(submitButton);

      // Workaround: use the reference to the button to submit the form. 
      HtmlPage newPage = submitButton.click();

      System.out.println(newPage.asText());
   }
}