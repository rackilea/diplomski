Imports System.IO
Imports System.Net
Imports System.Web.Script.Serialization ' Add Reference System.Web.Extensions

Module Program

    Public Function Authenticate(ByRef username As String, ByRef password As String) As String

        Dim UUID As String = Guid.NewGuid.ToString()
        Dim Request As HttpWebRequest = DirectCast(WebRequest.Create("https://authserver.mojang.com/authenticate"), HttpWebRequest)
        Request.ContentType = "application/json"
        Request.Method = "POST"

        Using Writer = New StreamWriter(Request.GetRequestStream())

            Dim Json As String = ("{ 'agent': {'name': 'Minecraft', 'version': 1}, 'username': '" + username + "', 'password': '" + password + "', 'clientToken': '" + UUID + "', 'requestUser': true }").Replace("'", Chr(34))

            Writer.Write(Json)
            Writer.Flush()
            Writer.Close()

            Dim Response = DirectCast(Request.GetResponse(), HttpWebResponse)
            Using Reader = New StreamReader(Response.GetResponseStream())
                Return Reader.ReadToEnd()
            End Using

        End Using

    End Function

    Sub Main()

        Dim Response As String = Authenticate("username", "password")
        Dim Serializer As JavaScriptSerializer = New JavaScriptSerializer()

        Dim Dictionary As Dictionary(Of String, Object) = Serializer.Deserialize(Of Dictionary(Of String, Object))(Response)

        Dim AccessToken As String = Dictionary("accessToken")
        Dim ClientToken As String = Dictionary("clientToken")

        Console.WriteLine(AccessToken)
        Console.WriteLine(ClientToken)
        Console.Read()

    End Sub

End Module