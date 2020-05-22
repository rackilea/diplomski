<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <body>
        <form method="get">
            <table>
                <tr>
                    <td><input type="button" value="submit" id="submit"> </td>
                    <div id="data"></div>
                </tr>
            </table>
        </form>
    </body>

    <script type="text/javascript">
        $(document).ready(function(){
            var val = "";
            $("#submit").click(function(event){
                event.preventDefault();

                $.ajax({
                    type: "GET",
                    dataType:"json",
                    url:  "rest/webservice",
                    success: function(data) {
                        console.log("response:" + data);
                        $.each(data, function(j, pdata) {
                            val= val + "[ "+pdata.firstName +" " + pdata.lastName +"]";
                        });
                        $("#data").text(val);
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.log(' Error in processing! '+textStatus);
                    }
                });
            });
        });
    </script>
</html>