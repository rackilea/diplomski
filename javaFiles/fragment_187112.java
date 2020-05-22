<%
//some stuff
boolean valid = false;
try {
    //some java code
    valid = true;
} catch(Exception e) {} %>

<script type="text/javascript">
if (<%=valid%>) {
//Some javascript code to try
}