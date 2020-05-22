function doReset(){

        var checkBxs = document.getElementsByName('partiesChBx');
        document.forms[0].selectdRwIds.value="";
        for(var i = 0; i < checkBxs.length; i++){
        checkBxs[i].checked = false; 
        }
}