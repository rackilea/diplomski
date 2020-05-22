package my.filter.package;

import com.sun.jersey.api.container.filter.UriConnegFilter;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;


public class MediaTypeFilter extends UriConnegFilter {
  private static final Map<String, MediaType> mappedMediaTypes = new HashMap<String, MediaType>(2);

  static {
    mappedMediaTypes.put("json", MediaType.APPLICATION_JSON_TYPE);
    mappedMediaTypes.put("xml", MediaType.APPLICATION_XML_TYPE);
  }

  public MediaTypeFilter() {
    super(mappedMediaTypes);
  }
}