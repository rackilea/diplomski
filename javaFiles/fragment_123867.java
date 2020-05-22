private int atoms;

// creates a Term with the provided values
public Term(char element, int atoms) {
    this.element = element;
    this.atoms = atoms;
}

// creates a Term by parsing s      
// e.g. "H20" would give element = 'H', atoms = 20 

public  Term(String s) {
    // TODO
    String e="";
    String at="";        
    char ch[]=s.toCharArray();

    for(int i=0;i<s.length();i++){

        if(ch[i]>=(char)65 && ch[i]<=(char)90 || ch[i]>=(char)97 && ch[i]<=(char)122){
            e=e+ch[i];
        }
        else{
            at=at+ch[i];
        }
    }
    System.out.println("element = '"+e+"'\t atom = "+at);
}

// turns the Term into a String      
// e.g. element = 'C', atoms = 4 would give "C4"
public String display() {
    // TODO 
    String trm=""+getElement()+getAtoms();
    return trm;
}

// returns the current value of element
public char getElement() {
    return element;
}

// returns the current value of atoms
public int getAtoms() {
    return atoms;
}