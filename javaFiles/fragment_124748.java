procedure TIndyLoginServer.SendRequest(Command, Json: string;
  Request: TRequest);
var
  JsonToSend: TIdStringStream;
  ServerResponse: string;
  Url: string;
begin
  // Build parameters
  JsonToSend := TIdStringStream.Create(Json);

  try
    try
      FIndyHttp.Request.Accept := 'application/json';
      FIndyHttp.Request.ContentType := 'application/json';
      FIndyHttp.Request.ContentEncoding := 'utf-8';


      Url := FUrl +'?command=' + Command;
      ServerResponse := FIndyHttp.Post(Url, JsonToSend);

      Request.OnRequestFinished(ServerResponse, '', '');
    except
      on E: EIdHTTPProtocolException do
      begin
        Request.OnRequestFinished('', E.Message, '');
      end;
      on E: EIdSocketError do
      begin
        if E.LastError = Id_WSAETIMEDOUT then
          Request.OnRequestTimedOut();
      end;
      on E: EIdException do
      begin
        Request.OnRequestFinished('', E.Message, '');
      end;
    end;
  finally
    JsonToSend.Free();
  end;
end;