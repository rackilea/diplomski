program New; 

 var hgauss : boolean;
 var ngauss : double;

  function gauss() : double;
  var x1, x2, w : double;
  begin
    if hgauss then
    begin
      result := ngauss;
      hgauss := false;
    end else
    begin
      repeat
        x1 := 2.0 * rand() - 1.0;
        x2 := 2.0 * rand() - 1.0;
        w := x1 * x1 + x2 * x2;
      until (w > 0.0)and (w < 1.0);   
      w := sqrt( -2.0 * ln( w ) / w );
      result := x1 * w;
      ngauss := x2 * w;
      hgauss := true;
    end;
  end;

begin
  writeln( gauss() );
  writeln( gauss() );
end.