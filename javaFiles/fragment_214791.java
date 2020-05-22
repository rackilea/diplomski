//this is your function I assume.
function toCreateCheckBoxesDynamically()
{
    create checkboxes dynamically;
    attach an attribute as onclick="function WhichTakesCheckedValuesAndAttachValuesToHiddenFields('dynamicallyCreatedCheckBoxName')" to the button.

                                        OR

    //bind a click event to the button and call this function "function WhichTakesCheckedValuesAndAttachValuesToHiddenFields('dynamicallyCreatedCheckBoxName')"
    document.getElementById("yourButton").addEventListener("click", function()
    {
          whichTakesCheckedValuesAndAttachValuesToHiddenFields('dynamicallyCreatedCheckBoxName');
    });
}

// this is the function which you call on button click while submitting the form
function whichTakesCheckedValuesAndAttachValuesToHiddenFields(checkboxName)
{
     var checkboxes = document.getElementsByName(checkboxName);
            var selected = "";
            for (var i=0; i<checkboxes.length; i++) 
            {
                if (checkboxes[i].checked) 
                {
                      if(selected == "" || selected == 'undefined')
                             selected = checkboxes[i].value;
                      else
                             selected = selected +","+ checkboxes[i].value;
                }
        }

    document.getElementById("hiddenFieldName").value = selected ;// the stored value is comma separated string so retrieve it on the server by using split method which will give you string array and then do your further work.
    document.getElementById("yourFormName").submit(); // submit this form
}