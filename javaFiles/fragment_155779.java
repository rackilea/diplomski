<html>
<head>
<script>


function checkAnswers(){
    var retval = false;
    var inputs = document.getElementsByTagName('input');

    for(i=0;i<inputs.length;i++){

        var inputName = inputs[i].getAttribute('name');            
        var msg = document.getElementById('msg-' + inputName);

        if(inputs[i].value == "yes" && inputs[i].checked == true){
            msg.innerHTML = 'Correct Answer!';      
        }
                else if(inputs[i].value == "yes" && inputs[i].checked != true){
                        msg.innerHTML = 'Wrong Answer!';
                }

    }
   return false;
}
</script>
</head>
<body>
<form name="myForm" onsubmit="return checkAnswers()">
    <h1>QUESTIONS</h1>
    <h3>Question No. 1.)</h3>What is the world's number 1 shampoo?
    <br />
    <input name="one" type="radio" value="yes"  />A. Hi
    <br />
    <input name="one" type="radio" value="no" />B. Hello
    <br />
    <input name="one" type="radio" value="no"  />C. Ahh
    <br />
    <input name="one" type="radio" value="no"  />D. Kitkat
    <br />
    <span id="msg-one"></span>
    <br />
    <h3>Question No. 2.)</h3>What is the world's number 1 shampoo?
    <br />
    <input name="two" type="radio" value="no"  />A. Hi
    <br />
    <input name="two" type="radio" value="yes"  />B. Hello
    <br />
    <input name="two" type="radio" value="no"  />C. Ahh
    <br />
    <input name="two" type="radio" value="no"  />D. Kitkat
    <br />
    <span id="msg-two"></span>
     <br/>
    <input type="button" name='submit' value="Submit"  />
</form>



</body>
</html>