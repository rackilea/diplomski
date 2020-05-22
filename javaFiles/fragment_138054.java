interface SomeApi {
    GET("/endpoint")
    fun getSomething(Query("user") user: String): Observable<SomeResponse>
}

fun SomeApi.someMethod(user : String) : Observable<Int>
    = processResponse(getSomething(user))