public Term add(Term that) throws IncompatibleTerms, CoefficientOverflow{
    //handle addition with term zero
        if(this.equals(Term.Zero)){
        return that;
    }else if(Term.Zero.equals(that)){
        return this;
    }

    if (this.expo != that.expo) throw new IncompatibleTerms();
    if((this.coef>= 0 && that.coef >= 0 && this.coef + that.coef <0) ||
            (this.coef<= 0 && that.coef <= 0 && this.coef + that.coef >0)){
                         throw new CoefficientOverflow();
        }    
    return new Term (this.coef + that.coef,expo);
}