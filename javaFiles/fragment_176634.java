@Controller
public class SitemapController {

    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    @ResponseBody
    public XmlUrlSet main() {
        XmlUrlSet xmlUrlSet = new XmlUrlSet();
        create(xmlUrlSet, "", XmlUrl.Priority.HIGH);
        create(xmlUrlSet, "/link-1", XmlUrl.Priority.HIGH);
        create(xmlUrlSet, "/link-2", XmlUrl.Priority.MEDIUM);

        // for loop to generate all the links by querying against database
        ...

        return xmlUrlSet;
    }

    private void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority) {
        xmlUrlSet.addUrl(new XmlUrl("http://www.mysite.com" + link, priority));
    }

}