// assumes hue [0, 360), saturation [0, 100), lightness [0, 100)

for(i = 0; i < 360; i += 360 / num_colors) {
    HSLColor c;
    c.hue = i;
    c.saturation = 90 + randf() * 10;
    c.lightness = 50 + randf() * 10;

    addColor(c);
}