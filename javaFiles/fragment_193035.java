String successStatus = "";
if ( returnval > 0 ){ 
    successStatus = "<font color=\"#3d9900\">" + returnval + " % </font>";
} else {
    successStatus = "<font color=\"#e64343\">" + returnval + " % </font>";
}

// other code should go here
// ...

<td align="right"><span class="box_acc_percent"><%= successStatus %></span></td>