String response = new String(ResponseData);
if(${BoolValue} == true)
{
    Failure = !(response.contains("growth"));
    if (Failure) {
      FailureMessage = "Projection values is showing in the response data for non-skill reports";
    }

}
if(${BoolValue} == false)
{
    Failure = (response.contains("growth"));
    if (Failure) {
      FailureMessage = "Projection values is not showing in the response data for skill reports";
    }
}