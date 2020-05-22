@Override
        protected Object clone() throws CloneNotSupportedException {
            MyClip clone = new MyClip(); 
            clone.set(this.dummy == null ? null : this.dummy.clone());     
            return clone;                            
        }