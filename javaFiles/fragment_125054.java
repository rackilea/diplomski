//this is a callback function that gets passed to your request for the file-System.
var onInitFs = function(fileSys){
    //fileSystem is a global variable
    fileSystem = fileSys;
    //once you have access to the fileSystem api, then you can create a file locally
    makeAFile();
    makeAndWriteContent();
};
var errorHandler = function(e){console.log('Error', e);};

//request 1 GB memory in a quota request
//note the internal callback `function(grantedBytes){...}` which makes the actual 
//request for the Filesystem, on success `onInitFs` is called. 
///on error the `errorHandler` is called
navigator.webkitPersistentStorage.requestQuota(1024*1024*1024*1, function(grantedBytes) {
    window.webkitRequestFileSystem(PERSISTENT, grantedBytes, onInitFs, errorHandler); 
}, errorHandler);

//this method will only work once the fileSystem variable has been initialized
function makeAFile(){
    var callbackFunctionOnSuccess = function(){console.log("created new file")}
    fileSystem.root.getFile("test.txt", {
        create: true
    }, callbackFunctionOnSuccess, function(error){console.log(error);});
}

function makeAndWriteContent(){
    //this is going to be passed as a callback function, to be executed after
    //contents are written to the test2.txt file.
    var readFile = function(){
       fileSystem.root.getFile("test2.txt", {create: false}, function(fileEntry) {
           fileEntry.file(function(file) {
              var reader = new FileReader();
              reader.onloadend = function(e) {
                console.log(this.result);
              };
              reader.readAsText(file);
           }, function(error){console.log(error);});
         }, function(error){console.log(error);});
    }


    fileSystem.root.getFile("test2.txt", {
        create: true
    }, function(fileEntry) {
        fileEntry.createWriter(function(writer) {
            writer.onwriteend = function(e) {
                writer.onwriteend = function(e){
                    //now, we will read back what we wrote.
                    readFile();
                }
                writer.onerror = function(e3){console.log(e3);
                }
                var blob = new Blob(["Hello World"]);
                writer.write(blob);
            };
            writer.onerror = function(e3) {console.log(e3);};
            //make sure our target file is empty before writing to it.
            writer.truncate(0);
        }, errorHandler);
    }, errorHandler);
}