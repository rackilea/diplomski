private fun saveDatabase(context : Context?){
    if(context != null){
    val fightersName = Match(1, fighter1.toString(), fighter2.toString(),
            minute.toInt(), round.toInt())

    val db = DBContract(context)
    db.insertData(fightersName)
    }
    }