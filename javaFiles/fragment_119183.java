MyPlugin = {
    myAction: function(success, error){
        cordova.exec(success, error, "MyPlugin", "myAction", []);
    }
}
module.exports = MyPlugin;