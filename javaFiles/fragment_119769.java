val ids: List[String] =  List("111@k2.com", "222@k2.com", "333@k2.com")
val indexedIds: List[(String, Int)] = ids.zipWithIndex

// Create a bunch of parameter tokens for the IN clause.. {id_0}, {id_1}, ..
val tokens: String = indexedIds.map{ case (id, index) => s"{id_${index}}" }.mkString(", ")

// Create the parameter bindings for the tokens
val parameters = indexedIds.map{ case (id, index) => (s"id_${index}" -> toParameterValue(id)) }

val sql1 = SQL(s"SELECT id,point,privacy FROM `pointTable` WHERE state=1 and  id in (${tokens})")
    .on(parameters: _ *)