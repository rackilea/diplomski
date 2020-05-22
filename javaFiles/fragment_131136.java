<script>
function ValidateEmail(inputText)
{
var val;
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(inputText.value.match(mailformat))
{
document.text1.focus();
val=true;

}
else
{
alert("You have entered an invalid email address!");
document.text1.focus();
val=false;

}
document.getElementById("demo").value=val;
}