this.transform
    .idt()
    .translate(originX, originY, 0)
    .rotate(0, 0, 1, rotation)
    .scale(scale, scale, 1)
    .translate(-originX / scale, -originY / scale, 0);
;