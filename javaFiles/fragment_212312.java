final String polygonname;

    switch (sides) {
    case 3:
        polygonname = "triangle";
        break;
    case 4:
        polygonname = "square";
        break;
    // Other cases....
    case 10:
        polygonname = "decagon";
        break;
    case 12:
        polygonname = "dodecagon";
        break;
    default:
        polygonname = "n-gon";

    }