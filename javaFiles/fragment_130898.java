<%
                ArrayList<String> branchlist = new ArrayList<String>();
                branchlist.add(0,"Computer Engineering");
                branchlist.add(1,"Information Technology");
                branchlist.add(2,"Electronic & Telecom");
                branchlist.add(3,"Instrumentation Engineering");
                branchlist.add(4,"Mechanical Engineering ");
                branchlist.add(5,"Civil Engineering");

                for(int i=0;i<branchlist.size();i++){
                    //System.out.println(branchlist.get(i)+"="+branch);
                    if(branchlist.get(i).toString().equals(branch)){%> 
                        <input  type="radio" name="branch" value="<%=branchlist.get(i)%>" checked="checked" ><%=branchlist.get(i) %><br>
                    <% }else {%>
                    <input type="radio" name="branch" value="<%=branchlist.get(i)%>" ><%=branchlist.get(i) %><br>

                <%}

                    }%>