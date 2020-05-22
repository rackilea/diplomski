private static int writeCharacter(String p)
    {
        if(p== "\\x0000")
            return 0x0000;
        else if(p== "\\x0001")
            return 0x0001;
        else if(p== "ぁ")
            return 0x0002;
        else if(p== "あ")
            return 0x0003;
        else if(p== "ぃ")
            return 0x0004;
        else if(p== "い")
            return 0x0005;
        else if(p== "ぅ")
            return 0x0006;
        ...
        else
            return 0x0000;
    }