String a = request.getParameter("Updat");

if ( (a is not empty) or (a is not null)  ) {
    ps = con.prepareStatement("Update Scope1 Set Query_Raised = '" + a + "'");

    int i = ps.executeUpdate();

    if(i == 1) {
        out.print("Done");
    } else{
        out.print("Error");
    }
}

...

<form action="whatever_action_you_have_which_will_call_this_JSP" ...>
    <tr> ... your code as in point#1
    </tr>
</form>