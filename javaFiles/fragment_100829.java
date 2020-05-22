String str = new String("Hawaede");
    int a=str.indexOf('d');
    int b=str.indexOf('e');
    if(a!=-1 && a<b) 
    {
        return 'd'
    }
    else if(b!=-1) return 'e';