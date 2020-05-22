// if(x_pos!=co.x_Cur&&y_pos!=co.y_Cur){
    delta_x = co.x_Cur - x_pos;
    delta_y = co.y_Cur - y_pos;
    direction = Math.atan2(delta_y, delta_x); 
    double speed = Math.sqrt(delta_x*delta_x + delta_y*delta_y);
    speed = Math.min(speed, 5.0);
    x_inc = (speed * Math.cos(direction));
    y_inc = (speed * Math.sin(direction));
    x_pos+=x_inc;
    y_pos+=y_inc;
//}