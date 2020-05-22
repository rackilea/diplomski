<form name="myForm" action="test.html" method="get"  onsubmit="return validateForm();">
        <label >First Name</label> <input type="text" id="firstName"/>
        <div>
            <input type="radio" name="radio1" id="one" value="one" onchange="display(this);"/>Eligible
        </div>
        <div>
            <input type="radio" name="radio2" id="two" value="two" onchange="display(this);"/>Not Eligible
        </div>
        <div id="text" class="glassy" name="mytext" style="display:none;">Other: <input type="text" id="dynbox"/>
        </div>
        <div> 
            <input type="hidden" name="mytext" value="${mytext}" />
            <br></br>
            <input type="submit" value="Submit"/>
        </div>
    </form>