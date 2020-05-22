@Grab( 'com.google.code.gson:gson:2.8.0' )
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

class Book {
    String name
    int isbn
    List<Author> authors
}

class Author {
    String name
    int age
}

def jsonString = '''
{
    "name": "Groovy", 
    "isbn": 12345, 
    "authors": [{
        "name": "John Doe", 
        "age": 30
     }, {
        "name": "Bill Nash", 
        "age": 40
     }] 
}
'''

//To Test
void assertions( book ) {
  book.with {
    assert name == 'Groovy'
    assert isbn == 12345
    assert authors
    assert authors[0].name == 'John Doe'
    assert authors[0].age == 30
    assert authors[1].name == 'Bill Nash'
    assert authors[1].age == 40
  }
}

/* JSON To POGO*/
//Using JsonSlurper
def book = new Book( new JsonSlurper().parseText( jsonString ) )
assertions book

//Using GSON
Gson gson = new Gson()
def bookUsingGson = gson.fromJson( jsonString, Book )
assertions bookUsingGson 

/* POGO To JSON */
//Using JsonBuilder
println new JsonBuilder( book ).toPrettyString()

//Using Gson
println gson.toJson( bookUsingGson )

//Using GsonBuilder for customization
GsonBuilder builder = new GsonBuilder()

// enable pretty print and seriliaze nulls
builder.setPrettyPrinting().serializeNulls()

// customize field title
builder.fieldNamingStrategy = { field -> field.name == "name" ? "title" : field.name }

// use the GsonBuilder to create a gson
Gson gsonBuilder = builder.create()

// pretty print
println gsonBuilder.toJson( bookUsingGson )