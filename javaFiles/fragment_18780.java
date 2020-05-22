program Project1;

{$APPTYPE CONSOLE}

{$R *.res}

uses
  System.SysUtils,
  System.Classes;

type
  TBaseObject = class(TObject)
  public
    b: integer;
    constructor Create; virtual;
  end;

  TBaseClass = class of TBaseObject;

  TObjectA = class(TBaseObject)
  public
    constructor Create; override;
  end;

constructor TBaseObject.Create;
begin
  inherited;
  b := 10;
end;

constructor TObjectA.Create;
begin
  inherited;
  b := 20;
end;

function BaseFactory(clazz: TBaseClass): TBaseObject;
begin
  Result := clazz.Create;
end;

var
  o: TBaseObject;
  c: TBaseClass;
begin
  o := BaseFactory(TBaseObject);
  writeln(o.b); // 10
  o.Free;

  o := BaseFactory(TObjectA);
  writeln(o.b); // 20
  o.Free;

  c := TObjectA;
  o := BaseFactory(c);
  writeln(o.b); // 20
  o.Free;

  readln;
end.