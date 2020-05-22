1. I should have used $.each($(".nameClass"), function(index, item) {
 2. and then $(item).autocomplete
 3. Also in source should have used source:function(request,response)
 4. In the ajax call request.term (which will take whatever you input in the autocomplete field where as my method was invoking the ajax call only after tab out.
 5. Map the data of response response($.map(data.data, function(item){
 6. Write a select callback function to make anything happen after i click on any entry in the typeahead
 7.data("ui-autocomplete")._renderItem = function (ul, item) { >To show the data in a formatted way after the ajax call.