public boolean find(BinaryNode p,int x)    
{    
        if(p==null) {    
                return false ;    
        }    
        else {    
         return (x==p.element)?true:(x<p.element?find(p.left,x):find(p.right,x));
        }
}