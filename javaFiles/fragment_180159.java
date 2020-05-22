function returnScreenshotImage(imageData) { 
    base64string = "data:image/png;base64,"+imageData;
    console.log("String: "+base64string);

    var url = 'http://www.websitename.co.uk/upload.php';
    var params = {image: imageData};

    document.basicfrm.oldscreenshotimg.value = document.basicfrm.screenshotimg.value;

    // send the data
    $.post(url, params, function(data) {
           document.basicfrm.screenshotimg.value = data;

           });    
}