$(document).ready(function()
{
    // If you want to disable showing the context menu when right clicking
    // on the document, the code below would do the trick.
    $(document).bind("contextmenu",function(e)
    {
        alert('right click capture');
        return false;
    }); 

    var $tree = $("#tree").kendoTreeView(
    {
        select: function (event)
        {
            var $item = $(event.node);
            console.log( $item );
            alert( "selected" );
        }
    });


    // Find the item you want to select...
    var $selected = $('#selected');
    var $treePath = $selected.parentsUntil($tree, "li");

    var treeView = $tree.data('kendoTreeView');

    // Expand the tree in order to show the selected item
    treeView.expand( $treePath );

    // Gotta make both calls...
    treeView.select( $selected );
    treeView.trigger( 'select', {node: $selected} );
});
​