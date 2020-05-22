function data(){
$(document).ready(function() {
$('#moeder').click(function() {
    $.ajax({
        url: 'MyServlet',
        type: 'GET',
        datatype: 'html',
        success : function(result) {
            jQuery("#ajaxGetUserServletResponse").html(result); //i added this line and it worked.

        }
    });
});
});
}