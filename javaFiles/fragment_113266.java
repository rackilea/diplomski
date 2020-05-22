NumberFormatInfo nfi = new NumberFormatInfo();
    nfi.NumberDecimalSeparator = ".";

    //** test **
    NumberFormatInfo nfi = new NumberFormatInfo();
    decimal d = 125501.0235648m;
    nfi.NumberDecimalSeparator = "?";
    s = d.ToString(nfi); //--> 125501?0235648