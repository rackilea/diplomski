function UTF8Bytes(const s: UTF8String): TArray;  
begin  
  SetLength(Result, Length(s)+1);  
  if Length(Result)>0 then  
    Move(s[1], Result[0], Length(s));  
  Result[high(Result)] := 0;  
end;