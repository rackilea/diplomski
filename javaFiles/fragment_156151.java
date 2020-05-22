function HexStringToBase64(const HexStr: string): string;
var
  md5bytes: TIdBytes;
begin
  SetLength(md5Bytes, Length(HexStr) div 2);
  HexToBin(PChar(HexStr), Pointer(md5Bytes), Length(md5Bytes));
  Result := TIdEncoderMIME.EncodeBytes(md5Bytes);
end;