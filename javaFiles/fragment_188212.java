$('#file_upload').uploadify({
  // your configuration...
  'onComplete'  : function(event, ID, fileObj, response, data) {
     $('#yourhtmlelement').html('the contents of the file=' + response);
   }
});