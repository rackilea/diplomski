<% List<Performer>obj1 = (List<Performer>) request.getAttribute("Performerobj"); %>
<script>
var obj=<%=new ObjectMapper().writeValueAsString(obj1)%>;
for(obj object : list)
{
  /*IS it correct way or how can i iterate*/
}
</script>