<%!
public void traverse(Node1 di,JspWriter out)throws IOException
{

    //System.out.println("Par"+di.data+"level"+level);
    out.println("<li class='folder'>"+di.data);
    if(di.right!=null)
    {
      out.print("<ul>");
      traverse(di.right,out);
      out.println("  </ul>");
    }
    if(di.left!=null)
    {
        traverse(di.left,out);
    }

}
%>
<div id="tree">
  <ul>
    <%traverse(n1,out); %>
  </ul>
 </div>