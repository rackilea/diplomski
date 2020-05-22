function success(myString){
    alert(myString);
}

function error(error){
    alert(JSON.stringify(error));
}

MyPlugin.myAction(success, error);