if(newnode.key <= n.key)
        { 
            if(n.lc==null){n.lc = newnode; break;}
            n = n.lc;
            System.out.println("left");
        }
        else
        { 
            if(n.rc==null){n.rc = newnode; break;}
            n = n.rc;
            System.out.println("right");
         }