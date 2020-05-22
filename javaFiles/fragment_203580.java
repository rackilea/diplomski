for( int i=0;i<acIDList.size();i++)
        {
           int acid=acIDList.get(i);
            acname=acNAMEList.get(i);
            //Print Category                
            int i = getIndex(acid);
       if(i != -1)              
       {        aname = attribNameList.get(i);
                aval = attribValueList.get(i);
                adata = attribDataList.get(i);
                //Print full data 
      if(!aval.equals("")) //add your cond to check empty ..
          {  %>
                <a style="color: black;"><%= acname %></a><br>
              <%
                    %><br>
                        <%-- <a><%= aname %></a> &nbsp; --%>
                        <a><%= aval %></a> &nbsp;
                        <%
                            if(adata == null)
                            {         /*add you msg or html in case of null*/                   }
                            else //here all html with content and design
                            {  %>   <a><%= adata %></a>
                                <%
                            }
                }  }
            %>   <br>   <% 
        }