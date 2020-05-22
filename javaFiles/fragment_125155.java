//Initialize our submit flag to false
var formSubmitted = false;

/**
 * Prevent from submitting a form more than once
 * @returns {Boolean}
 */
function submitForm()
{   
  //has the form been submitted before?
  if( formSubmitted == true )
  {
     alert("This form has already been submitted!");
     return false;
  }
  formSubmitted = true;

  return true; // Submit form
}