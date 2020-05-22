<html>
<script language="javascript">
var myLink = "";
function hideMe() {
    document.getElementById('btn3').style.visibility='hidden';
}
function setMyAdd() {
    location.href=myLink;
}
function checkForChange() {
    document.getElementById('btn1').style.visibility='visible';
    document.getElementById('btn2').style.visibility='visible';
    var buttonSelected=selList.value;
    // alert("Option Selected is : " + buttonSelected );
    if (buttonSelected=="optx") {
    myLink = "myPage2.html";
    document.getElementById('btn1').style.visibility='hidden';
    document.getElementById('btn2').style.visibility='visible';
    document.getElementById('btn3').style.visibility='visible';
    } else {
    myLink = "myPage1.html";
    document.getElementById('btn1').style.visibility='visible';
    document.getElementById('btn2').style.visibility='hidden';
    document.getElementById('btn3').style.visibility='visible';
    }
}
</script>
<body onLoad="hideMe()">
<form>
<select onChange="checkForChange()" id="selList">
    <option value="opt0" selected>Choose Option</option>
    <option value="opt1">Option 1</option>
    <option value="opt2">Option 2</option>
    <option value="opt3">Option 3</option>
    <option value="optx">Option X</option>
</select>
<BR><br>
<input type="button" value="Option 1,2,3" id="btn1">
<BR>
<input type="button" value="Option X" id="btn2">
<BR>
<input type="image" value="Click me" src="SR_@_Indian_GP.jpg" width=100 height=100 id="btn3" onClick="setMyAdd(); return false;">
</form>
</body>
</html>