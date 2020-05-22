exports.newObject = function(){
    return new Utilities();
}

var Utilities = function(){
    this.method1 = function(args, callback){
        var self = this;
        someCallbackFunction(args,function(){       
            self.method2(args,function(){
            });
        });  
    }

   this.method2 = function(args, callback){
       this.method1();   
    }

   this.method3 = function(args, callback){
       //stuff
    }
}