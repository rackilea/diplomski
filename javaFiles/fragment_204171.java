for (int i = 0; i < geoCountry.size(); i++) {
         if (usercountries.contains(geoCountry.get(i)) {
             %>
            <option value="<%=geoCountry.get(i)%>" selected="selected"><%=geoCountry.get(i)%></option>
             <% } else {%>
             <option value="<%=geoCountry.get(i)%>"><%=geoCountry.get(i)%></option>
          <% }
       } %>