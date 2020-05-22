@Grab('com.google.code.gson:gson:2.7+')
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Client {
    @SerializedName("Name")
    String name

    @SerializedName("Birthdate")
    Date birthdate
}

def client = new Client(name: 'John', birthdate: new Date())

def strJson = new Gson().toJson(client)
println strJson