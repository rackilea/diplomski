<%int number=2;%>
<br><br>Matricula: 

<select id="mat" name="mat" >

<option <%if(number==1){%>selected<%}%> >
01</option>
<option <%if(number==2){%>selected<%}%> >
02</option>
<option <%if(number==3){%>selected<%}%> >
03</option>
<option <%if(number==4){%>selected<%}%> >
04</option>

</select>