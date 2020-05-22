<form id="main" method="post" name="main" action="" onsubmit="redirect(this);">
    <input type="submit" name="submit"/> 
</form>


function redirect(elem){
     elem.setAttribute("action","somepage.jsp");
     elem.submit();
}