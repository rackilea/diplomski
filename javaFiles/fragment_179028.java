(function($){ 
   var scaleCheckboxesAndRadioButtons = function(scale) {
     var $elements= $('input[type="checkbox"], input[type="radio"]');
     $elements.css("-webkit-transform", "scale(" + scale + ")");
  }
}(jQuery));