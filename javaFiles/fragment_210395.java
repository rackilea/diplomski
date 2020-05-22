enum TypeX implements MessageType 
{ 
   X1, 
   X2 
}

class HandlerX extends Handler<TypeX>
    handle(TypeX type)
        if(type==X1) 
        ...

----

class TypeY implements MessageType
{ 
   int x; 
}

class HandlerY extends Handler<TypeY>
     handle(TypeY type)
         if(type.x==0) 
         ...