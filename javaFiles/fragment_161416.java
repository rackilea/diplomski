//For left track

    //Decide how far away the track is from the tank
    _xOffset = _itemAnimation.getHeight() / 1.5;

    //Decide where the track is horizontally to the tank (Ie front, back)
    _DegreeToRadien = Math.toRadians(_degrees + 110);

    //Set the point of the track, takes the centre of the tank and adds the current position, cos and sin basically divide (though multiplication) the current position according to the direction the tank is facing.
    _trackLeftPosition.set
    (
        _ObjectXCenter + (int)(_xOffset * Math.cos(_DegreeToRadien))
        ,
        _ObjectYCenter + (int)(_xOffset * Math.sin(_DegreeToRadien))
    );