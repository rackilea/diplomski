JSONObject t = JSON.parse(params.myObject)
t.each { id, data ->
    println id
    data.each { prop, value ->
       println prop + " = " + value
    }
}