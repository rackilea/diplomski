function doRefresh()
{
    if(document.forms[0].onsubmit)
    {
        document.forms[0].submit();
    }
}

function openChild()
{
     window.open("path_to_child.jsf","_blank","");
     return false;
}