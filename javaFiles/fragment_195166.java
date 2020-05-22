@XStreamAlias("result")
public class Result {

   protected String source_url;
   protected String destination_url;
   protected String source_ip;
   protected String source_title;
   protected String visited;
   protected String anchor;
   protected String rating;
   protected String link_type;
   protected Boolean is_nofollow;

public Result() {

}

public String getSource_url()
{

return source_url;
}

public void setSource_url(String source_url)
{

this.source_url=source_url;
}

public String getDestination_url()
{

return destination_url;
}

public void setDestination_url(String destination_url)
{

this.destination_url=destination_url;
}

public String getSource_ip()
{

return source_ip;
}

public void setSource_ip(String source_ip)
{

    this.source_ip=source_ip;
}


public String getSource_title()
{

return source_title;
}

public void setSource_title(String source_title)
{

this.source_title=source_title;
}


public String getVisited()
{

return visited;
}

public void setVisited(String visited)
{

this.visited=visited;
}


public String getAnchor()
{

return anchor;
}

public void setAnchor(String anchor)
{

this.anchor=anchor;
}


public String getRating()
 {

return rating;
 }

public void setRating(String rating)
{

this.rating=rating;
}


public String getLink_type()
{

return link_type;
}

public void setLink_type(String link_type)
{

    this.link_type=link_type;
}

public Boolean getIs_nofollow() {
    return is_nofollow;
}

public void setIs_nofollow(Boolean is_nofollow) {
    this.is_nofollow = is_nofollow;
}