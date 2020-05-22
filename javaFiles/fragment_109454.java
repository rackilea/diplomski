private String url;

public String getUrl()
{
 return url;
}

public String execute()
{
 [other stuff to setup your date]
 url = "/section/document" + date;
 return "redirect";
}