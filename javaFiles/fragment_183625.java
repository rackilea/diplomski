<%
    HashMap<Integer,String> hm =new HashMap<Integer,String>();
    hm.put(1,"abc");
    hm.put(2,"def");
    hm.put(3,"ghi");

     for(int i=1;i<hm.size();i++){
%>
      <option value="<%= i%>"><%= hm.get(i) %></option>
<% } %>