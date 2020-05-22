string yourString = "this,is,a,example,string";
        string newString = "";

        string[] array = yourString.Split(',');

        foreach (string s in array)
        {
            newString += s;
        }

        Console.WriteLine(newString);