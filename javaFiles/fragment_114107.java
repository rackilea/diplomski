var
  i, px, py, tx, ty, XX, YY, ptx, pty: Integer;
  perplen, alonglen: Double;
  wdt, lng: Integer;
  Fi, cs, sn: Double;
begin
  px := 300;    py := 300;
  wdt := 150;   lng := 250;
  Fi := Pi / 6;   cs := Cos(Fi);   sn := Sin(Fi);
  Canvas.Brush.Color := clBlack;
  Canvas.Ellipse(px - 5, py - 5, px + 6, py + 6);  //player

  Canvas.Brush.Style := bsClear;
  Canvas.MoveTo(px, py);
  XX := px - Round(Wdt / 2 * sn);  YY := py + Round(Wdt / 2 * cs);
  Canvas.LineTo(XX, YY);
  XX := XX + Round(lng * cs);   YY := YY + Round(lng * sn);
  Canvas.LineTo(XX, YY);
  XX := XX + Round(Wdt * sn);   YY := YY - Round(Wdt * cs);
  Canvas.LineTo(XX, YY);
  XX := XX - Round(lng * cs);   YY := YY - Round(lng * sn);
  Canvas.LineTo(XX, YY);
  Canvas.LineTo(px, py);  //rectangle finished

  for i := 0 to 99 do begin
    tx := 100 + Random(600);  //random target
    ty := 100 + Random(600);
    ptx := tx - px;
    pty := ty - py;
    perplen := Abs(ptx * sn - pty * cs);
    alonglen := ptx * cs + pty * sn;
    if (perplen <= Wdt / 2) and (alonglen >= 0) and (alonglen <= lng) then
      Canvas.Brush.Color := clBlue  // in region
    else
      Canvas.Brush.Color := clRed;
    Canvas.Ellipse(tx - 3, ty - 3, tx + 4, ty + 4);
  end;