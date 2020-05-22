function validateForm() {
$('#save').attr('disabled', 'disabled');
var isValid = false;
var noOfRows = '${num}';
var webSiteArray = new Array();
var imageNameArray = new Array();
for(var i=0; i<noOfRows; i++) {
    var web = "web"+i;
    var req = "req"+i;
    var res = "res"+i;
    var image = "image"+i;

    var webSiteUrl =  document.getElementById(web).value;
    var imageNameValue =  document.getElementById(image).value;
    webSiteArray[i]= webSiteUrl;
    imageNameArray[i]= imageNameValue;
    var newReqUrl = document.getElementById(req).value;
    var newResUrl = document.getElementById(res).value;
    isValid = checkParm(webSiteUrl,newReqUrl,newResUrl);
    if (!isValid) {
       $('#save').removeAttr("disabled");
       return false;
    }
}

if (isValid) {
    if (checkValueisEqual(webSiteArray, imageNameArray)) {
      return true;
    }
    return false;
} }