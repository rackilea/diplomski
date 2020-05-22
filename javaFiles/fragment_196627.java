@JsonIgnoreProperties(ignoreUnknown = true)    
    @XmlRootElement
    public FruitCounter
    {
       int numberOfApples;
       int numberOfOranges;

       public int getNumberOfApples()
       {
          return this.numberOfApples();
       }

       public int setNumberOfApples(int numberOfApples)
       {
          this.numberOfApples = numberOfApples;
       }

       public int getNumberOfOranges()
       {
          return this.numberOfOranges();
       }

       public int setNumberOfOranges(int numberOfOranges)
       {
          this.numberOfOranges = numberOfOranges;
       }
    }