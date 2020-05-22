public boolean equals (SomeClass other)
    {
        if (other instanceof SomeClass) {
            return this.privateMember==((SomeClass)other).privateMember;
        }
        else { 
            return false;
        }
    }