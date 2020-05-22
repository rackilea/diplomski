float checkA = ((bounds.pointList[check].x-position.x)*frustrum.x) +
            ((bounds.pointList[check].y-position.y)*frustrum.y);

    float checkB = ((bounds.pointList[check].x-position.x)*frustrum.x) +
            ((bounds.pointList[check].z-position.z)*frustrum.z);
    if(checkB>=0&&checkA>=0) {
        visible = true;
        return;
    } else if(checkB<0&&checkA<0) {
        visible = false;
        return;
    } else {
       float checkC = ((bounds.pointList[check].y-position.y)*frustrum.y) +
            ((bounds.pointList[check].z-position.z)*frustrum.z);
       if(checkC>=0) {
          visible = true;
          return;
       } else {
          visible = false;
          return;
       }

    }