(function () {
    'use strict';

    function init(event) {
       window.foo = function() {
          console.log("javascript foo() function called from android");
       }
    }

    window.addEventListener('load', init, false);

}());

function foo1(){
   console.log("javascript foo1() function called from android");
}