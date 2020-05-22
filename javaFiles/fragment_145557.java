function xorString(txt, key: string): string;
var
  i: integer;
  ch: byte; //change to word for D2009+
  digit: string;
begin
  result := '';
  for i := 1 to length(txt) do
  begin
    ch := byte(txt[i]) xor byte(key[i]); //change byte to word for D2009+
    digit := IntToHex(ch, 2);
    result := result + digit;
  end;
end;