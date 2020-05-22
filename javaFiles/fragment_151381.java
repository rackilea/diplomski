unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ScktComp, ExtCtrls, StdCtrls;

type
  CustomRec = record
    Zahl: Byte;
  end;

TForm1 = class(TForm)
    edit1: TEdit;
    ClientSocket1: TClientSocket;
    ServerSocket1: TServerSocket;
    Label1: TLabel;
  procedure ServerSocket1ClientError(Sender: TObject;
    Socket: TCustomWinSocket; ErrorEvent: TErrorEvent;
    var ErrorCode: Integer);
  procedure MyServerSocket1ClientRead(Sender: TObject;
    Socket: TCustomWinSocket);
  procedure ClientSocket1Error(Sender: TObject; Socket: TCustomWinSocket;
    ErrorEvent: TErrorEvent; var ErrorCode: Integer);
    procedure FormActivate(Sender: TObject);
private
public
  { Public-Deklarationen }
end;

var
  Form1: TForm1;

implementation

{$R *.dfm}


procedure TForm1.ServerSocket1ClientError(Sender: TObject;
  Socket: TCustomWinSocket; ErrorEvent: TErrorEvent;
  var ErrorCode: Integer);
begin
  Errorcode := 0;
end;

procedure TForm1.MyServerSocket1ClientRead(Sender: TObject; Socket: TCustomWinSocket);
var
  rec: CustomRec;
  sInt, reply: string;
  iInt, errorPos: Integer;
begin
  edit1.Text := Socket.ReceiveText;

  sInt := StringReplace(Trim(Edit1.Text), '''', '', [rfReplaceAll]);
  Val(sInt, iInt, errorPos);

  if errorPos = 0 then begin
    if iInt in [Low(Byte)..High(Byte)] then begin
      rec.Zahl := iInt;
      iInt := iInt +1;
      reply := IntToStr(rec.Zahl);
    end;
  end
  else
    reply := '-1';
    reply := 'reply ' + reply + ' accepted';
  Socket.SendText(reply + #13#10);
end;

procedure TForm1.ClientSocket1Error(Sender: TObject;
  Socket: TCustomWinSocket; ErrorEvent: TErrorEvent;
  var ErrorCode: Integer);
begin
  Errorcode := 0;
end;

procedure TForm1.FormActivate(Sender: TObject);
begin
  ClientSocket1 := TClientSocket.Create(Self);
  ClientSocket1.OnError := ClientSocket1Error;

  ServerSocket1 := TServerSocket.Create(Self);
  ServerSocket1.OnClientError := ServerSocket1ClientError;
  ServerSocket1.OnClientRead := MyServerSocket1ClientRead;

  ClientSocket1.Port := 10003;
  ClientSocket1.Host := '127.0.0.1';

  ServerSocket1.Port := 10003;
  ServerSocket1.Open;
end;

end.