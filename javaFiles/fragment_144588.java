public void mousePressed(int mod, Point loc) {
    pressLocation=copyLocation(loc,pressLocation);
    dragLocation=null;
    }

public void mouseReleased(int mod, Point loc) {
    if(pressLocation!=null && dragLocation!=null) {
        // Mouse drag reverted to mouse click - not dragged far enough
        // action for click
        pressLocation=null;
        }
    else if(dragLocation!=null) {
        // action for drag completed
        }
    else {
        // do nothing
        }

    pressLocation=null;
    dragLocation=null;
    }

public void mouseDragged(int mod, Point loc) {
    if(pressLocation!=null) {                                                   // initial drag actions following mouse press
        dragLocation=pressLocation;                                             // consider dragging to be from start point
        if(Math.abs(loc.x-pressLocation.x)<dragMinimum && Math.abs(loc.y-pressLocation.y)<dragMinimum) {
            return;                                                             // not dragged far enough to count as drag (yet)
            }
        // action drag from press location
        pressLocation=null;
        }
    else {
        // action drag from last drag location
        dragLocation=copyLocation(loc,dragLocation);
        }
    }