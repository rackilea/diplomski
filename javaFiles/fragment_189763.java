@if (@x)==(@y) @end /***** jscript comment ******
     @echo off

     cscript //E:JScript //nologo "%~f0" "%~1"
     exit /b 0

 @if (@x)==(@y) @end ******  end comment *********/

 var app_name = WScript.Arguments.Item(0);
 var shell =  WScript.CreateObject("WScript.Shell");
 shell.AppActivate(app_name);
 shell.SendKeys("% x");