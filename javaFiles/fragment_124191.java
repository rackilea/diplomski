public class getpassword(or getuser) extends BodyTagSupport
{
   public int doEndTag() {
      Doc doc = pageContext.getRequest().getAttribute("doc");
      if(doc == null)
      {
         pageContext.getRequest().setAttribute("doc", doc = builder.build(file));
      }
      out.println(doc);
       ...
   }
}