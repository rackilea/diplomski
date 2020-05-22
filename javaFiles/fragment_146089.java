public void doGet(HttpServletRequest req, HttpServletResponse resp) 
  throws IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("yourvalue");
 }

<script>
 $(document).ready(function(){
    //sends ajax get request
    $.get( "myServlet", function( data ) {
        //Do your logic with the response
        if(data == "myvalue"){
            $("p").css("display", "none");
         }
    });
 });
</script>