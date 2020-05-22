success: function(responseData) {
    // refresh method removed
    // get the responseData as JSON or something from the server
    Liferay.Util.getOpener().updateDataFromPopUp("JSON-data-passed");
    Liferay.Util.getOpener().closePopup('popUpId');                                        
}