ArrayList<Character> alist=new ArrayList<>();
    alist.add('+');
    alist.add('-');
    alist.add('/');
    alist.add('%');
    char c='A';
    if(alist.contains(c))
    {
        System.out.println("UNREACHABLE");
    }