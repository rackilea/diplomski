package custom;

import javax.faces.webapp.UIComponentELTag;

public class CustomErrorTag extends UIComponentELTag {

  @Override
  public String getComponentType() {
    return "custom.Errors";
  }

  @Override
  public String getRendererType() {
    return "custom.CustomErrorRenderer";
  }

}