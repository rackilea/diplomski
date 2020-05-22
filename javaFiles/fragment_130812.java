@Column(nullable = false)
     private Boolean include;
     ...
     public static class Builder {
      private Boolean include = true; // Here it comes your default value
      public Builder include (Boolean include ) {
      this.include = include ;
      return this;
     }
     // Use the pattern builder whenever you need to persist a new entity.
     public MyEntity build() {
       MyEntity myEntity = new MyEntity ();
       myEntity .setinclude (include );
       return myEntity;
      }
...
}