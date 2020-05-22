long init = System.currentTimeMillis();

for(int i = 0; i < 1000000; ++i)
{
    Field[] fields = User.class.getDeclaredFields();

    for(Field field : fields)
    {
        field.getName();
    }
}

System.out.println(System.currentTimeMillis()-init);