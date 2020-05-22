else{
            if(!stack.isEmpty())
                char pop=stack.pop(); // Here you initialized the value inside a condition.
            else
                return false;
            if(c==')'&&pop!='(') return false;
            else if(c==']'&&pop!='[') return false;// Using the value.
            else if(c=='}'&&pop!='{') return false;// Using the value.
        }