For Each btn in div.getElementsByTagName("a")
    If btn.getAttribute("href") = "javascript:mainMenuSubmit('mop_mis');" Then
        btn.Click
        Exit For
    End If
Loop