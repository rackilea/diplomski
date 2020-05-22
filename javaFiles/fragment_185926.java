public interface SimpleTestService {
String endpoint = "http://jsonplaceholder.typicode.com";

@GET("/posts")
Observable<List<Post>> getPosts();
}