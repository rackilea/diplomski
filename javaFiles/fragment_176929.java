To have my applet work;
1- I exported the applet as jar file(named as printApplet.jar) and copied it under the same folder as my xhtml page.
2- I put the applet in xhtml as below;
         <applet id="myApplet"
            code="com.xxx.yyy.console.action.PrintApplet"
            archive="printApplet.jar" width="1" height="1">         
        </applet>
3- I created a method `enter code here`in the applet which gets printer names as string and has comma(,) between the names. 
4- I called the applet methods using javascript as below;
<script type="text/javascript" >
    //<![CDATA[
    function getPrinters() {
        var aplt = document.getElementById("myApplet");     
        var printers = aplt.getPrinterNames();
        var p = printers.split(',');
        var c = document.getElementById("combo");
        for ( var i = 0; i < p.length; i++) {
            var o = document.createElement("option");
            o.text = p[i];
            o.value = i;
            try {
                c.add(o, null); //Standard 
            } catch (error) {
                c.add(o); // IE only
            }
        }
    }   
    //]]>
</script>