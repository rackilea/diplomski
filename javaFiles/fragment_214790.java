function getCheckedItems(checkboxName) {
        var checkboxes = document.getElementsByName(checkboxName);
                var selected = [];
                for (var i=0; i<checkboxes.length; i++) 
                {
                    if (checkboxes[i].checked) 
                    {
                         selected.push(checkboxes[i].value);
                }
         }
       return selected;
    }