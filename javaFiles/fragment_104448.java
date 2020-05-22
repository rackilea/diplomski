class Issue{

  @PostUpdate
  protected void onPostUpdate(){
    //This method wil run after the update
    if(this.state == Resolved){
         //...
    }
  }