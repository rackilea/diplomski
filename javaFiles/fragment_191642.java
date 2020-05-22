float change;
float tba = (ba / 100 < 1) ? ba + 360 : ba;
float tma = (ma / 100 < 1) ? ma + 360 : ma;
float tea = (ea / 100 < 1) ? ea + 360 : ea;
    if(tba > tma && tma > tea && ea > ba)
        change = ea - ba - 360;
    else if(tba < tma && tma < tea && ea < ba)
        change = tea - ba;
    else if(ea < ba && ma < ba)
        change = ea - ba;
    else
        change = (ea - ba < 0f) ? ea - ba + 360 : ea - ba;
    change %= 360;