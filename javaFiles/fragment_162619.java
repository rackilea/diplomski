class RomanNumeral{
  String roman;

  public RomanNumeral(String roman){
    this.roman = roman;
  }

  public RomanNumeral Clone(){
    return new RomanNumeral(this.roman);
  }

  public int GetValue(){
    int sum = 0;
    int carry = 0;
    for(int i = 0; i< roman.Length;i++)
    {
     if(i<roman.Length-1){
       if(GetRomanValue(roman[i])>GetRomanValue(roman[i+1])){
          sum += GetRomanValue(roman[i]) - carry;
          carry = 0;
       }
     else carry = GetRomanValue(roman[i]);
    }
    else sum += GetRomanValue(roman[i]) - carry;
  }
 }

  int GetRomanValue(char c)
  {
    switch(c){
     case 'I': return 1;
     case 'V': return 5;
     //and so on...
    }
   }
}