Character[] c = {'a','b','c','e'};
        Character[] p = {'b', 'c','e','u','o'};
        List<Character> fl = new ArrayList(Arrays.asList(c));
        //List<Character> fl = Arrays.asList(c);
        for(char x : p)
        {
        System.out.println(x);
        if(fl.contains(x))
        {
        //System.out.println("hello");
        fl.remove(new Character(x));
        }
        else
        {
        fl.add(x);
        }
        }
        System.out.println(fl);