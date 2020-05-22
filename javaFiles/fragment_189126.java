public void preorder(hnode temp)
{
    if( temp!= null)
    {
        System.out.println(temp.key);
        preorder(temp.l);
        preorder(temp.r);

    }  
}