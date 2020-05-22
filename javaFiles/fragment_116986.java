// Promote 3 elements attached to the dom to 3 GWT Panel Widgets
    $("#bar1, #bar2, #bar3").as(Widgets).panel();

    horizontalPanel.add($("#bar1").widget());
    horizontalPanel.add($("#bar2").widget()); 
    horizontalPanel.add($("#bar3").widget());