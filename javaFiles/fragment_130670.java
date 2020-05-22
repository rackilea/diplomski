public Temperature otherUnit(TempUnit unit) {
    switch(unit) {
        case Celcius: {
            //If the current temperature is in Celcius, then return the current object.
            if(this.unit == TempUnit.celcius) return this;            
            // return a new object which has the equivalent temperature in Celcius.
        }
        ...    
    }
}