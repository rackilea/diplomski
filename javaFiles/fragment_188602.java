function setText(element){
var arr_main=document.getElementById("txtHidStr").value.split("#");
for(i=0;i<arr_main.length;i++)
{
     arr_val=arr_main[i].split("@");
     if(arr_val[0]==element.value)
     {
        document.getElementById("jDesc").innerHTML=arr_val[1];
        break;
     }
}
}