switch(event.getType()){
        case "mousedown":
            isMouseDown = true;
            break;
        case "mouseup":
        case "mouseout":
            isMouseDown=false;
            break;
        case "mousemove":
            if(isMouseDown)  thisMove(event);
            break;
        default:
            break;
    }