uses
  System.Classes,
  System.NetEncoding;

function HexStringToBase64(const HexStr: string): string;
var
  md5bytes: TBytes;
begin
  SetLength(md5Bytes, Length(HexStr) div 2);
  HexToBin(PChar(HexStr), Pointer(md5Bytes), Length(md5Bytes));
  Result := TNetEncoding.Base64.EncodeBytesToString(md5Bytes);
end;