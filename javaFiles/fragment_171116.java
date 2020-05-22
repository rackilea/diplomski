@Entity
class Request
{
   @OneToMany(mapped-by="request", cascade=CascadeType.ALL)
   public List<Response> getResponses()
   // implementation    

}

@Entity
class Response 
{
   @OneToOne
   @JoinColumn(name="request_id")
   public Request getRequest()
   // implementation
}