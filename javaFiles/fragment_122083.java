<html><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <SCRIPT LANGUAGE="JavaScript">
            function selectedCity() 
            {
                var elem = document.getElementById('cityRb');

                if(elem.checked)
                {
                    document.SimpleMessageApplet.setMessage(elem.value);
                }      
            }
        </SCRIPT></HEAD>
    <BODY >
        <b>This is the Applet</b>
    <APPLET CODE="MessageApplet.class" NAME="SimpleMessageApplet" WIDTH=350 HEIGHT=100 >
    </APPLET >
    <FORM NAME="CityChoice">
        <input type="radio" id="cityRb" name="City" value="Boston" onClick="selectedCity()"> Boston<br>
    </form>
</BODY > 
</html>