@(ClientDetails: java.util.HashMap[String, String])

@import helper._

@main("ADMS") {

   <center>
    <form id="select">
   <a>CONSULTANT</a>
   @select(Form.form()("Consultant"),           
       options(ClientDetails),
       'value -> "clientName1"[any value that should be selected by default])
     <table border="1">
       <tr>
       <td width=50px>Client</td>
       <td width=50px>Project</td>
       <td width=50px>Task</td>
       <td width=50px>Date</td>
       <td width=50px>Consultant</td>
       <td width=50px>Role</td>
       <td width=80px>Is Billable</td>
       </tr>
       <tr>
       <td>@ClientDetails</td>
       </tr>
       </table>
      </form>
   </center>
}