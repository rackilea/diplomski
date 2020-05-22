(function(){
    const oldEval = window.eval;
    window.eval = function () {

        // communicate here with your Java program that eval has been
        // called. Maybe you can use the postMessage method?

        return oldEval.apply(this, arguments);
    };
})();