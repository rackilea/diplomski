private static GenericCallback instance;

public static GenericCallback getHandler() {
    return instance;
}

@Override
protected void onCreate(Bundle savedInstanceState)
{
     ...
     instance = this;
     ...
}