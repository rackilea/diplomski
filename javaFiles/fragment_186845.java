import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class Test {

    public static void main(String[] args) throws Throwable {
        HtmlCleaner cleaner = new HtmlCleaner();
        String html = "<div style=\"Z-INDEX: 654; BORDER-BOTTOM: 0px; POSITION: absolute; BORDER-LEFT: 0px; WIDTH: 80px; HEIGHT: 22px; BORDER-TOP: 0px; TOP: 64px; CURSOR: auto; BORDER-RIGHT: 0px; LEFT: 240px\" id=\"textboxElt11286249556014dIi15v\" lineid=\"lineid\" pos_rel=\"false\" x1=\"240\" x2=\"320\" y1=\"64\" y2=\"86\"><input style=\"WIDTH: 80px; HEIGHT: 20px\" id=\"textboxElt11286249556014dIi15v_textbox\" title=\"Enter Registration Number Here\" tabindex=\"1\" value=\" \" maxlength=\"15\" size=\"10\" name=\"scheduled_tribe_registration_number_text\"></input></div>";
        TagNode node = cleaner.clean(html);
        TagNode div = node.findElementByName("div", true);
        System.out.println(div.getAttributeByName("style"));
    }
}